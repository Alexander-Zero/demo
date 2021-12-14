    val list01 = new ListBuffer[Int]()
    // .+=(ele) 向后添加 
    list01.+=(1)
    // .+=:(ele) 向头添加
    list01.+=:(2)
    // .++(list) 整体添加到括号中的链表
    list02.++(list01)