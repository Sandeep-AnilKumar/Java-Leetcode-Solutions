package Threads;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MessagingSimulator {
    private static BlockingQueue<Message> queue;

    public MessagingSimulator(int capacity) {
        queue = new LinkedBlockingQueue<>(capacity);
    }

    static class Message {
        private User sender;
        private String text;

        public Message(User sender, String text) {
            this.sender = sender;
            this.text = text;
        }
    }

    static class User {
        private String name;

        public User(String name) {
            this.name = name;
        }
    }

    static class ChannelIn implements Runnable {
        User user;
        String[] sampleMessages;
        BlockingQueue<Message> channel;
        Random random;

        public ChannelIn(User user, String[] sampleMessages, BlockingQueue<Message> channel) {
            this.user = user;
            this.sampleMessages = sampleMessages;
            this.channel = channel;
            random = new Random();
        }

        @Override
        public void run() {
            while(true) {
                try {
                    System.out.println(user.name + " is typing. . .");
                    Thread.sleep(random.nextInt(5000));
                    int index = random.nextInt(sampleMessages.length) ;
                    channel.put(new Message(user, sampleMessages[index]));
                    Thread.sleep(random.nextInt(15000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ChannelOut implements Runnable {
        User user;
        String[] sampleMessages;
        BlockingQueue<Message> channel;
        Random random;

        public ChannelOut(User user, String[] sampleMessages, BlockingQueue<Message> channel) {
            this.user = user;
            this.sampleMessages = sampleMessages;
            this.channel = channel;
            random = new Random();
        }

        @Override
        public void run() {
            System.out.println("Current user is : " + user.name);
            while(true) {
                try {
                    Message message = channel.take();
                    if (!message.sender.name.equals(user.name)) {
                        System.out.println("\t\t\t" + message.sender.name + ": " + message.text + "\n");
                    }
                    
                    if (random.nextBoolean()) {
                        int index = random.nextInt(sampleMessages.length);
                        System.out.println("\t\t\t\t\t\t\t\t" + sampleMessages[index] + "\n");
                        channel.put(new Message(user, sampleMessages[index]));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        MessagingSimulator simulator = new MessagingSimulator(100);
        User[] users = new User[5];
        String[] names = {"Joe", "John", "Kelly", "Iris", "Adam"};
        int index = 0;

        for (String name : names) {
            users[index++] = new User(name);
        }

        Random random = new Random();
        index = random.nextInt(5);
        User currentUser = users[index];
        List<Thread> userThreads = new LinkedList<>();
        String[] sampleMessages = {"Hi, how you doing?", "How's work going?", "Let's go out sometime",
                "What did you do over the weekend?", "Haha Lol!", "Watched any new movies?", "Did you hear about Anna?",
                "What have you been doing lately?", "Wow! you got a new car?", "I heard its snowing in Tahoe", ":D", ":@", ":)"};

        for (User user : users) {
            if (!user.name.equals(currentUser.name)) {
                userThreads.add(new Thread(new ChannelIn(user, sampleMessages, queue)));
            } else {
                userThreads.add(new Thread(new ChannelOut(currentUser, sampleMessages, queue)));
            }
        }

        for (Thread thread : userThreads) {
            thread.start();
        }

        try {
            for (Thread thread : userThreads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
