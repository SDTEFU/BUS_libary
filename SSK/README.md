# Synchronous-Scalable-Keep

> ### master 

| 方向  | 名称  |  意义    
|:----:|:----: |:----|
| out  | mosi  | 发送端
| in   | miso  | 接收端
| out  | clk   | 同步时钟
| out  | done  | 切片信号用于给发送的数据做切片
| out  | lock  | 保持信号，保持和某一个设备通讯，保持后可同时收发数据

> - 每个时钟上升沿用来区分数据
> - 高电平为1低电平为0
