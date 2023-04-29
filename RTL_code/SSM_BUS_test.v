// Generator : SpinalHDL v1.8.1    git head : 2a7592004363e5b40ec43e1f122ed8641cd8965b
// Component : SSM_BUS_test
// Git hash  : c3b1ae97990b45c62e206510221cf0755b8a41bc

`timescale 1ns/1ps

module SSM_BUS_test (
  output     [31:0]   io_inin_addr,
  output     [31:0]   io_inin_write,
  input      [31:0]   io_inin_read,
  output              io_inin_acces,
  output              io_inin_rw,
  input               io_inin_done,
  input      [31:0]   io_outout_addr,
  input      [31:0]   io_outout_write,
  output     [31:0]   io_outout_read,
  input               io_outout_acces,
  input               io_outout_rw,
  output              io_outout_done
);


  assign io_inin_addr = io_outout_addr;
  assign io_inin_write = io_outout_write;
  assign io_outout_read = io_inin_read;
  assign io_inin_acces = io_outout_acces;
  assign io_inin_rw = io_outout_rw;
  assign io_outout_done = io_inin_done;

endmodule
