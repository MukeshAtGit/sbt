package demo
import akka.actor.{Props,Actor,ActorSystem}
object Akka extends App{
val actorSystem=ActorSystem("actorsystem")
val actor=actorSystem.actorOf(Props[Demo],"Start")
actor! "hi.."
actorSystem.stop(actor)

}
class Demo extends Actor{
def receive={
case message:String=>{println("reciver  ="+self.path.name+"/nsender  ="+sender.path.name+"/n and message ="+message)

}
case _ =>println("enter string only please")



}
override def postStop()={
println("actor is stop")
}



}


