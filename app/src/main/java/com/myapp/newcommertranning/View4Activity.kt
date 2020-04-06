package com.myapp.newcommertranning

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.user_add.*
import java.io.FileNotFoundException
import java.io.IOException


class View4Activity : AppCompatActivity() {
    val REQUEST_GET_IMAGE = 100

    var imageView1: ImageView? = null
    var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_add)
        setSupportActionBar(toolbar)
        imageView1 =
            findViewById<View>(R.id.camera_preview) as ImageView

        findViewById<View>(R.id.btnImage).setOnClickListener(buttonNumberListener)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnAdd.setOnClickListener {view ->
            AlertDialog.Builder(this) // FragmentではActivityを取得して生成
                .setTitle("ユーザ登録確認")
                .setMessage("入力された内容でユーザー登録を行います。\nよろしいですか？")
                .setPositiveButton("OK") { dialog, which ->
                    // TODO:Yesが押された時の挙動

                }
                .setNegativeButton("No") { dialog, which ->
                    // TODO:Noが押された時の挙動
                }
                .show()
        }
    }

    var buttonNumberListener =
        View.OnClickListener {
            val pickPhotoIntent = Intent(
                Intent.ACTION_GET_CONTENT
            )
            pickPhotoIntent.type = "image/*"
            val takePhotoIntent = Intent(
                MediaStore.ACTION_IMAGE_CAPTURE
            )
            val chooserIntent = Intent.createChooser(
                pickPhotoIntent, "Picture..."
            )
            chooserIntent.putExtra(
                Intent.EXTRA_INITIAL_INTENTS, arrayOf(takePhotoIntent)
            )
            startActivityForResult(
                chooserIntent,
                REQUEST_GET_IMAGE
            )
        }
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
        if (REQUEST_GET_IMAGE == requestCode && resultCode == Activity.RESULT_OK && data != null
        ) {
            try {
                if (data.extras != null &&
                    data.extras!!["data"] != null
                ) {
                    val capturedImage = data.extras!!["data"] as Bitmap?
                    imageView1!!.setImageBitmap(capturedImage)
                } else {
                    val stream = contentResolver.openInputStream(
                        data.data!!
                    )
                    val bitmap = BitmapFactory.decodeStream(stream)
                    stream!!.close()
                    imageView1!!.setImageBitmap(bitmap)
                }
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}


