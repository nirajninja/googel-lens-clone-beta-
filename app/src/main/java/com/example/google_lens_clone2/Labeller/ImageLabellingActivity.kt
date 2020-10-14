package com.example.google_lens_clone2.Labeller

import androidx.camera.core.ImageAnalysis
import androidx.core.content.ContextCompat
import com.example.google_lens_clone2.BaseLensActivity

class ImageLabellingActivity :BaseLensActivity()
{
    override val imageAnalyzer=ImageLabelAnalyser()

    override fun startScanner() {
startImageLabelling()
    }
    private fun startImageLabelling()
    {
        imageAnalysis.setAnalyzer(ContextCompat.getMainExecutor(this),
        imageAnalyzer)
    }

}