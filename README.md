# Movement
Реализовать IoC контейнер, который:

1.Разрешает зависимости с помощью метода, со следующей сигнатурой:
T IoC.Resolve(string key, params object[] args);

2.Регистрация зависимостей также происходит с помощью метода Resolve
IoC.Resolve("IoC.Register", "aaa", (args) => new A()).Execute();

3.Зависимости можно регистрировать в разных "скоупах"
IoC.Resolve("Scopes.New", "scopeId").Execute();
IoC.Resolve("Scopes.Current", "scopeId").Exceute();

Указание: Если Ваш фреймворк допускает работу с многопоточным кодом, то для работы со скоупами используйте ThreadLocal контейнер.