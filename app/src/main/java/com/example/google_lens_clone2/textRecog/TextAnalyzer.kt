package com.example.google_lens_clone2.textRecog

import android.annotation.SuppressLint
import android.util.Log
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition

class TextAnalyzer : ImageAnalysis.Analyzer {

    val recognizer= TextRecognition.getClient()
    @SuppressLint("UnsafeExperimentalUsageError")
    override fun analyze(imageProxy: ImageProxy) {

        Log.d("TEXT","image analysed")
        imageProxy.image?.let{

            val inputImage= InputImage.fromMediaImage(it,imageProxy.imageInfo.rotationDegrees)
            recognizer.process(inputImage)
                .addOnSuccessListener {text->
                    //val barcodes=code
                    text.textBlocks.forEach { block->
                        Log.d("TEXT","""
                        LINES=${block.lines.joinToString("\n"){it.text}}
                            
                        """.trimIndent())

                    }

                }

                .addOnFailureListener {ex->

                    Log.e("TEXT","Detection failed",ex)

                }.addOnCompleteListener {
                    imageProxy.close()
                }
        }
            ?:imageProxy.close()
    }
}