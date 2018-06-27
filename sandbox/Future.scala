import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.golbal

object FutureSample extends App {
  val s = "Hello"
  val f: Future[String] = Future {
    Thread.sleep(1000)
    s + " future!"
  }

  f.foreach { case s: String => 
    println(s)
  }

  println(f.isCompleted)

  Thread.sleep(5000)
  val f2: Future[String] = Future {
    Thread.sleep(1000)
    throw new RuntimeException("わざと失敗")
  }

  f2.failed.foreach { case e: Throwable => 
    println(e.getMessage)
  }

  println(f2.getMessage)
  Thread.sleep(5000)

  println(f2.isCompleted)
}

