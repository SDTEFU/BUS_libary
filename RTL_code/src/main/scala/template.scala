import spinal.core._
import spinal.lib._
//define_bus=======================================================================================

case class SSM_BUS(wigth: Int) extends Bundle with IMasterSlave {
  val addr = Bits(wigth bits)
  val write = Bits(wigth bits)
  val read = Bits(wigth bits)
  val acces = Bool()
  val rw = Bool()
  val done = Bool()

  override def asMaster(): Unit = {
    out(addr, write, acces, rw)
    in(read, done)
  }
}
//define_bus====================================================================================

class SSM_BUS_test extends Module {
  val io = new Bundle {
    val inin = master(SSM_BUS(32))
    val outout = slave(SSM_BUS(32))
  }
  io.outout <> io.inin
}

object template extends App {
  SpinalVerilog(new SSM_BUS_test())
}
