package dev.sampalmer

import org.scalajs.dom._
import utest._

object ScrabookJsTest extends TestSuite {
  def setupDom(): (HTMLButtonElement, HTMLDivElement) = {
    val div = document.createElement("div").asInstanceOf[HTMLDivElement]
    div.setAttribute("id", "hello")
    val button = document.createElement("button").asInstanceOf[HTMLButtonElement]
    button.setAttribute("id", "click")
    document.body.insertAdjacentElement("afterbegin", div)
    document.body.insertAdjacentElement("afterbegin", button)
    (button, div)
  }
  def tests = Tests {
    test("ScrapbookJs") {
      val (button, div) = setupDom()
      ScrapbookJs.setup()
      button.click()
      assert(div.textContent == "bob")
    }
  }
}
