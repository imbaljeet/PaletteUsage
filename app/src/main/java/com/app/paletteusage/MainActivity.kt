package com.app.paletteusage

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.core.graphics.ColorUtils
import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUi()

        val colorSelectionArrayAdapter = ColorSelectionArrayAdapter(ColorsModel.colorsList)
        images_spinner.adapter = colorSelectionArrayAdapter

        images_spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val colorsModel = ColorsModel.colorsList[position]

                image_view.setImageResource(colorsModel.colorImage)
                setUi()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }

    private fun setUi() {
        invalidateUi()
        val bitmap = image_view.drawable.toBitmap()

        val generatedPalette = Palette.from(bitmap).generate()

        Log.d(TAG, "swatches: ${generatedPalette.swatches}")

        val vibrantSwatch = generatedPalette.vibrantSwatch

        var dominantColor = generatedPalette.getDominantColor(Color.BLACK)

        if (vibrantSwatch != null) {
            dominantColor = vibrantSwatch.rgb
        }
        val textColor = if (ColorUtils.calculateLuminance(dominantColor) >= 0.5) {
            Color.BLACK
        } else {
            Color.WHITE
        }

        generatedPalette.dominantSwatch?.let {
            dominantColor = it.rgb
        }

        val calculateLuminance = ColorUtils.calculateLuminance(dominantColor)

        text_view_luminance.text = "Luminance : $calculateLuminance"

        text_view_text_color.setTextColor(textColor)
        text_view_text_color.setBackgroundDrawable(image_view.drawable)

        text_view_dominant_color.setBackgroundColor(dominantColor)
    }

    private fun invalidateUi() {
        text_view_text_color.setTextColor(Color.BLACK)
        text_view_text_color.setBackgroundColor(Color.TRANSPARENT)
        text_view_luminance.text = "INVALIDATED"
    }
}