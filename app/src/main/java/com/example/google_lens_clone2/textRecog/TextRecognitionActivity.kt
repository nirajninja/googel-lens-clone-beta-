package com.example.google_lens_clone2.textRecog

import androidx.camera.core.ImageAnalysis
import androidx.core.content.ContextCompat
import com.example.google_lens_clone2.BaseLensActivity

class TextRecognitionActivity:BaseLensActivity() {
    override val imageAnalyzer=TextAnalyzer()


    override fun startScanner() {
        startTextRecognition()
    }
    private fun startTextRecognition()
    {   imageAnalysis.setAnalyzer(
        ContextCompat.getMainExecutor(this),
        imageAnalyzer
    )
    }
}