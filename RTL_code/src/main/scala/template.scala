import spinal.core._
import spinal.lib.IMasterSlave


class SSM_BUS extends Bundle with IMasterSlave{
  val addr = Bits(32 bits)
  val write = Bits(32 bits)
  val read = Bits(32 bits)
  val acces = Bool()
  val rw =Bool()
  val done =Bool()

  override def asMaster(): Unit = {
    out(addr,write,acces,rw)
    in(read,done)
  }
}

class SSM_BUS_test extends Module{

}

object template extends App {
  SpinalVerilog(new SSM_BUS_test())
}
