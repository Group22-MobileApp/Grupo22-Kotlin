package com.example.grupo22_kotlin.presentation.utils

import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
<<<<<<< HEAD
=======
import android.media.MediaScannerConnection
>>>>>>> Dev
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.FileProvider
import com.example.grupo22_kotlin.R
import org.apache.commons.io.FileUtils
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
<<<<<<< HEAD
import java.util.UUID
=======
import java.util.*
>>>>>>> Dev

class ComposeFileProvider: FileProvider(R.xml.file_paths) {

    companion object {

        fun createFileFromUri(context: Context, uri: Uri):File?{
          return try {
              val stream = context.contentResolver.openInputStream(uri)
              val file = File.createTempFile(
                  "${System.currentTimeMillis()}",
                  ".png",
                  context.cacheDir
              )
              FileUtils.copyInputStreamToFile(stream, file)
              return file

          } catch (e: Exception){
              e.printStackTrace()
              return null
          }
        }
        fun getImageUri(context: Context): Uri {

            val directory = File(context.cacheDir, "images")
            directory.mkdirs()
            val file = File.createTempFile(
                "selected_image_",
                ".jpg",
                directory
            )
            val authority = context.packageName + ".fileprovider"
            return getUriForFile(
                context,
                authority,
                file
            )
        }
<<<<<<< HEAD
=======

>>>>>>> Dev
        fun getPathFromBitmap(context: Context, bitmap: Bitmap): String {
            val wrapper = ContextWrapper(context)
            var file = wrapper.getDir("Images", Context.MODE_PRIVATE)
            file = File(file,"${UUID.randomUUID()}.jpg")
            val stream: OutputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream)
            stream.flush()
            stream.close()
            return file.path
        }
<<<<<<< HEAD
=======

>>>>>>> Dev
    }

}