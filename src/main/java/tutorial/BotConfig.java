package tutorial;

//класс конфигурации, хранит имя и токен
public class BotConfig {
    private final String botUsername;
    private final String botToken;

    public BotConfig() {
        this.botUsername = System.getenv("BOT_USERNAME");
        this.botToken = System.getenv("BOT_TOKEN");

        if (botUsername == null || botToken == null) {
            throw new RuntimeException("Не заданы переменные окружения BOT_USERNAME или BOT_TOKEN");
        }
    }

    public String getBotUsername() {
        return botUsername;
    }

    public String getBotToken() {
        return botToken;
    }
}
