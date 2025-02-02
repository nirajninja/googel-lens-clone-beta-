package com.example.google_lens_clone2.Barcode

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage

class BarcodeAnalyzer:ImageAnalysis.Analyzer {

    val scanner=BarcodeScanning.getClient()
    @SuppressLint("UnsafeExperimentalUsageError")
    override fun analyze(imageProxy: ImageProxy) {
        Log.d("BARCODE","image analysed")
        imageProxy.image?.let{

            val inputImage=InputImage.fromMediaImage(it,imageProxy.imageInfo.rotationDegrees)
            scanner.process(inputImage)
                .addOnSuccessListener {code->
                 val barcodes=code
                    code.forEach { barcode->
                        Log.d("BARCODE","""
                            Format=${barcode.format}
                             Value=${barcode.rawValue}
                        """.trimIndent())
                        
                    }

                }

                .addOnFailureListener {ex->

                    Log.e("BARCODE","Detection failed",ex)

                }.addOnCompleteListener {
                    imageProxy.close()
                }
        }
            ?:imageProxy.close()
    }

}