package com.app.paletteusage

data class ColorsModel(
        val colorImage: Int
) {
    companion object {
        val colorsList = listOf(
                ColorsModel(colorImage = R.drawable.ic_1),
                ColorsModel(colorImage = R.drawable.ic_2),
                ColorsModel(colorImage = R.drawable.ic_3),
                ColorsModel(colorImage = R.drawable.ic_4),
                ColorsModel(colorImage = R.drawable.ic_5),
                ColorsModel(colorImage = R.drawable.ic_6),
                ColorsModel(colorImage = R.drawable.ic_7),
                ColorsModel(colorImage = R.drawable.ic_8)
        )
    }
}