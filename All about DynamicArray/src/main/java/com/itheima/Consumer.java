package com.itheima;

public interface Consumer <T>{
    void accept(T t);

}

//在 Java 中，泛型接口允许接口处理不同类型的数据，而不必为每种类型单独编写接口。Consumer<T> 就是这样一个泛型接口，T 是一个类型参数，代表它可以接受任何类型的数据。
//
//解释：
//泛型接口
//Consumer<T> 是一个泛型接口，其中 T 代表一个类型占位符。它允许在使用该接口时根据需要指定具体的类型。例如，Consumer<Integer> 代表的是一个专门用于处理 Integer 类型的 Consumer。
//
//T 被指定为 Integer
//在代码中，当你使用 Consumer<Integer> 时，你正在告诉编译器，T 这个泛型类型应该被替换为 Integer，因此，accept(T t) 方法的参数类型就会变成 Integer。这样一来，accept 方法就只能接受 Integer 类型的参数