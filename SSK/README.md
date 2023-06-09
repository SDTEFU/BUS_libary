# Synchronous-Scalable-Keep(通用同步可拓展串型总线)
> #### 此为标准版本只支持一个主机，扩展版本支持多主机: [SSK-plus](./SSK-plus)

### Sign(master)

| 方向  | 名称  |  意义    
|:----:|:----: |:----|
| inout| mosi  | 主设备发送从设备接收
| inout| miso  | 主设备接收从设备发送
| out  | clk   | 同步时钟由主设备发送
| out  | lock  | 保持信号，保持和某一个设备通讯，保持后可同时收发数据

> **可给同时miso和mosi拓展(2^n)-1 (n>=0)根信号线使同一个时间段可以发送接收多个数据(拓展模式)** 


#### 功能
> - 可拓展数据线：可拓展数据线的数量使同一个时钟沿发送多个数据
> - 可支持多个主设备，当多个主设备需要控制总线时可通过仲裁功能选择控制总线的主设备
> - 全双工模式：mosi发送数据同时miso接收数据
> - 半双工模式：mosi和miso变成双向数据线
> - 单工模式：mosi和miso变成单向数据线
#### 信号约束(物理约束)
> - 最先发送数据的LSB
> - 最小的数据宽度为1byte
> - 低电平为0,高电平为1
> - 时钟空闲为0
> - 上升沿触发下降沿采样
> - lock信号为1时有效
> - 应答信号为1

### 通讯过程
> 1. 主设备通过miso和mosi发送要通讯的地址进行通讯设备广播
> 2. 在发送最后一个地址的bit同时置lock为1表示绑定设备
> 3. 在下一个时钟的下降沿检查miso是否有应答信号，若有则表示连接成功
> 4. 通讯结束置lock为0

### 清除选中过程
> 误置lock为1后可以通过在下降沿置回0
### 优点
> 1. 只用给现有的spi设备加一个地址判断器就可以完成修改
> 2. 兼容所有spi总线的通讯内容，拓展简单且直接
> 3. 改善了spi总线与多个设备通讯时需要拓展cs信号线造成线过多的接口浪费