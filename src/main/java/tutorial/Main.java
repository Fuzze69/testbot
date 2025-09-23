package tutorial;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

// Главный класс приложения, запускает телеграмм бота
public class Main {
    public static void main(String[] args) {
        try {
            BotConfig config = new BotConfig();

            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new MyBot(config));

            System.out.println("Бот запущен!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
