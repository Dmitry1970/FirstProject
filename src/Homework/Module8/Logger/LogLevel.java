package Homework.Module8.Logger;

public enum LogLevel {

    TRACE("для ещё большего количества ещё более детальных отладочных сообщений"),
    DEBUG("для отладочных сообщений"),
    INFO("для информационных сообщений"),
    WARN("для предупреждений"),
    ERROR("для логирования ошибок"),
    FATAL("для критических ошибок");

    String description;

    LogLevel(String description) {
        this.description = description;
    }
}
