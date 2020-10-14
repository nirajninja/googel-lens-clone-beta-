package com.example.google_lens_clone2.Barcode

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.example.google_lens_clone2.BaseLensActivity
import com.example.google_lens_clone2.R
import kotlinx.android.synthetic.main.activity_lens.*

class Barcode_Activity : BaseLensActivity() {
    companion object {
        @JvmStatic
        val CAMERA_PERM_CODE = 422
    }
    override  val imageAnalyzer= BarcodeAnalyzer()
    override fun startScanner() {
        scanBarcode()
    }


    private fun scanBarcode() {

    imageAnalysis.setAnalyzer(
        ContextCompat.getMainExecutor(this),
        imageAnalyzer
    )

    }



}