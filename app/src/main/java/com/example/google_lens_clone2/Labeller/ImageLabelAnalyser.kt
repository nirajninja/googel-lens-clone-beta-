package com.example.google_lens_clone2.Labeller

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.label.ImageLabeling
import com.google.mlkit.vision.label.defaults.ImageLabelerOptions

class ImageLabelAnalyser:ImageAnalysis.Analyzer {
   private val labeler=ImageLabeling.getClient(ImageLabelerOptions.Builder()
       .setConfidenceThreshold(0.7F)
   .build()
   )



    @SuppressLint("UnsafeExperimentalUsageError")
    override fun analyze(imageProxy: ImageProxy) {
        Log.d("LABEL","image analysed")
        imageProxy.image?.let{

            val inputImage= InputImage.fromMediaImage(it,imageProxy.imageInfo.rotationDegrees)
            labeler.process(inputImage)
                .addOnSuccessListener {labels->
                    val barcodes=labels
                    labels.forEach { label->
                        Log.d("LABEL","""
                            Format=${label.text}
                             Value=${label.confidence}
                            """.trimIndent())

                    }


                }


                .addOnFailureListener {ex->

                    Log.e("LABEL","Detection failed",ex)

                }.addOnCompleteListener {
                    imageProxy.close()
                }
        }
            ?:imageProxy.close()

    }
}