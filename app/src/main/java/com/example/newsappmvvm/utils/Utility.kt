package com.example.newsappmvvm.utils

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.net.ConnectivityManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.newsappmvvm.data.models.local.ModelArticle
import com.example.newsappmvvm.data.models.local.ModelNews
import com.example.newsappmvvm.data.models.local.ModelSourceX
import com.example.newsappmvvm.data.models.local.relations.ArticleAndNews
import com.example.newsappmvvm.data.models.remote.NewsModel
import com.example.newsappmvvm.data.models.remote.Sources
import javax.inject.Inject


fun Activity.showMsg(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}

fun Fragment.showDialog(
    message: String?, posActionName: String?,
    onPosClick: DialogInterface.OnClickListener?,
    negativeText: String?,
    onNegativeClick: DialogInterface.OnClickListener?,
    isCancelable: Boolean
) {
    val builder = AlertDialog.Builder(requireContext())
    builder.setMessage(message)
    builder.setPositiveButton(posActionName, onPosClick)
    builder.setNegativeButton(negativeText, onNegativeClick)
    builder.setCancelable(isCancelable)
    val dialog: AlertDialog = builder.create()
    dialog.show()
}


class NetworkState @Inject constructor(val context: Context) : CheckNetworkState {


    override fun isOnline(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        val activeNetworkInfo = connectivityManager!!.getActiveNetworkInfo()
        return activeNetworkInfo != null && activeNetworkInfo.isConnected()

    }


    override fun ConvertModelRemoteToLocal(newsModel: NewsModel): ArticleAndNews {

        val articles = newsModel.articles.map {

            ModelArticle(
                0,
                0,
                check(it.author),
                check(it.content),
                check(it.description),
                check(it.publishedAt),
                check(it.title),
                check(it.url),
                check(it.urlToImage)
            )
        }

        val news = ModelNews(0, newsModel.status, newsModel.totalResults)
        return ArticleAndNews(news, articles)
    }

    private fun check(string: String): String {
        return string ?: "empty"
    }

    override fun ConvertModelRemoteToLocal(modelSourceX: Sources): List<ModelSourceX> {
        return modelSourceX.sources.map {
            ModelSourceX(
                0, it.category, it.country, it.description, it.id, it.language,
                it.name, it.url
            )
        }
    }


}






