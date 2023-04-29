## BUS Libary
> #### Streamline-Scala-Module (SSM) BUS

> **master**          

|输入/输出| 位宽(bits)  |信号名        | 说明          
|:---:   | :----:     |:----:       | :----:      
|in      | 32         | m_addr      |主设备访问外设地址  
|in      | 32         | m_write     |主设备写数据      
|out     | 32         | m_read      |主设备读到的数据  
|in      | 1          | m_acces_f   |主设备访问请求标志 
|in      | 1          | m_rw_f      |主设备读/写标志      
|out     | 1          | m_done_f    |主设备完成标志 
> **slave**

|输入/输出| 位宽(bits)   |信号名      | 说明          
|:---:   | :----:      | :----:    |:----:   
|out     | 32          | s_addr    |从设备写地址
|out     | 32          | s_read    |从设备读到的数据
|in      | 32          | s_write   |从设备写数据
|out     | 1           | s_acces_f |从设备访问请求标志
|out     | 1           | m_rw_f    |从设备读/写标志 
|in      | 1           | s_done_f  |从设备完成访问标志
> 标志信号说明

|标志信号         |  说明  
|:---:           |  :----:
|主设备访问请求标志 |主设备请求访问外设
|主设备读/写标志   |为1时表示向外设写数据/为0时表示向外设读数据
|主设备访问完成标志 |从设备完成把数据写到总线/完成从总线读数据
|从设备访问请求标志 |(连接)主设备访问请求标志 
|从设备读/写标志   |(连接)主设备读/写标志 
|从设备完成访问标志 |(连接)主设备访问完成标志 

> ## 通讯过程
>> ### 主设备读数据
>>> 主设备把要读数据的外设地址发送到m_addr，且m_rw_f置0,然后m_acces_f产生一个长度为一时钟周期的脉冲信号，此时从设备会把数据发送到s_write上被m_read接收然后从设备产生一个长度为一时钟周期的脉冲信号发送到s_done_f被m_done_f接收完成数据的读
>> ### 主设备写数据
>>> 主设备把要写数据的外设地址发送到m_addr，要写的数据发送到m_write上，且m_rw_f置1,然后m_acces_f产生一个长度为一时钟周期的脉冲信号，此时从设备会通过s_read读到要写的数据， 写数据完成后从设备产生一个长度为一时钟周期的脉冲信号发送到s_done_f被m_done_f接收完成数据的读