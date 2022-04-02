package dev.sampalmer

import org.scalajs.dom
import org.scalajs.dom.html.{Button, Input}
import org.scalajs.dom.{Element, Event, document}
import sttp.client3._
import sttp.model.Method

import org.scalajs.macrotaskexecutor.MacrotaskExecutor.Implicits._

object ScrapbookJs {
  def main(args: Array[String]): Unit = {
    document.addEventListener("DOMContentLoaded", { (_: dom.Event) =>
      setup()
    })
  }
  def setup(): Unit = {
    val button = document.querySelector("#click").asInstanceOf[Button]
    val url = document.querySelector("#url").asInstanceOf[Input].value
    button.addEventListener("click", (e: Event) => {
      val backend = FetchBackend()
      val fileInput = document.querySelector("#file").asInstanceOf[Input]
      val request = basicRequest
        .body(fileInput.files.head)
        .method(Method.PUT, uri"$url")
      backend.send(request).map(e => {
        e.body.map(e => println(e)).left.map(println)
        println(e.is200)
      })
    })
  }
}