package ipsen5.utils;

import ipsen5.repository.PostRepository;
import ipsen5.repository.UserRepository;
import ipsen5.models.Post;
import ipsen5.models.User;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@Component
public class PostSeeder {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public PostSeeder(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public byte[] readJpgAsBytes(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.readAllBytes(path);
    }


    public void seedPost() throws IOException {
        String jpgFilePath = "src/main/resources/images/picture1.jpg";
        byte[] jpgData = readJpgAsBytes(jpgFilePath);

        String jpgFilePath2 = "src/main/resources/images/picture2.jpg";
        byte[] jpgData2 = readJpgAsBytes(jpgFilePath2);

        String jpgFilePath3 = "src/main/resources/images/picture3.jpg";
        byte[] jpgData3 = readJpgAsBytes(jpgFilePath3);

        String jpgFilePath4 = "src/main/resources/images/picture4.jpg";
        byte[] jpgData4 = readJpgAsBytes(jpgFilePath4);

        List<User> allUsers = userRepository.findAll();
        Post post1 = new Post();
        post1.setUser(allUsers.get(0));
        post1.setText("In the annals of history, Babylon stands as a beacon of ancient marvels. Among these, the Hanging Gardens have long captivated the imagination of scholars and adventurers alike. Yet, the truth behind these verdant wonders is a tapestry woven with both myth and reality.\n\n" +
                "Nimrod, the fabled king and hunter, is said to have founded Babylon with the blessings of the gods. His vision was not merely for a city but for a utopia, a place where the heavens and earth could meet. The Hanging Gardens were the epitome of this dream. Constructed as a towering ziggurat, the gardens cascaded down in lush terraces, each one a step closer to the divine.\n\n" +
                "Built to please his wife, Amytis, who longed for the green hills of her homeland, these gardens were a marvel of engineering. Watered by an ingenious irrigation system that defied the arid climate, they were a symbol of man's ability to conquer nature. Yet, they were also a testament to the delicate balance between humanity and the divine.\n\n" +
                "As the centuries passed, the Hanging Gardens became more than just a symbol of love and power. They were a reminder of Babylon's grandeur and its fall. Each leaf, each flower, whispered tales of a time when gods walked among men, and the boundaries of what was possible were continually pushed.\n\n" +
                "Today, as we delve into the ruins and unravel the secrets buried beneath the sands, we rediscover not just a lost wonder but a lesson. The Hanging Gardens of Babylon are a testament to human ingenuity and the eternal quest to reach beyond our grasp, to touch the divine, if only for a fleeting moment.");
        post1.setTitle("Rediscovering Babylon: The Truth Behind the Hanging Gardens");
        post1.setImageUrl(jpgData);
        post1.setLocalDate(LocalDate.now());
        post1.setGenres(List.of("Fantasy", "Adventure"));
        postRepository.save(post1);

        Post post2 = new Post();
        post2.setUser(allUsers.get(0));
        post2.setText("In a world where the line between reality and fantasy blurs, the verdant wonders of the earth hold secrets that defy comprehension. These enigmatic landscapes are not merely beautiful; they are gateways to realms of the unknown.\n\n" +
                "Take, for instance, the lush rainforests that blanket our planet's equator. These green havens are teeming with life, each leaf and vine a thread in the intricate web of existence. Yet, beneath their emerald canopy lies a world of mystery and wonder. Ancient trees, their roots intertwined with time itself, guard secrets older than human civilization.\n\n" +
                "One such legend speaks of the lost city of El Dorado, hidden deep within the Amazon rainforest. This city of gold, its streets paved with the shimmering metal, is said to hold untold treasures and wisdom. But it is not the gold that draws explorers; it is the promise of the unknown. For El Dorado is not just a city; it is a beacon of mankind's insatiable curiosity, a symbol of the quest to uncover the hidden wonders of our world.\n\n" +
                "As we journey through these verdant realms, we are reminded of our place in the grand tapestry of life. The forests, with their ancient wisdom, teach us that there is more to the world than meets the eye. They beckon us to explore, to dream, and to believe in the enigmatic wonders that lie just beyond the horizon.");
        post2.setTitle("Verdant Wonders: Exploring the Enigmatic");
        post2.setImageUrl(jpgData3);
        post2.setLocalDate(LocalDate.now().minusDays(9));
        post2.setGenres(List.of("Science", "Fiction"));
        postRepository.save(post2);

        Post post3 = new Post();
        post3.setUser(allUsers.get(0));
        post3.setText("In the annals of history, there are tales of places so wondrous, so enchanting, that they seem to belong to another realm entirely. One such place is the Lost Paradise of the ancient world, a utopia where nature and humanity coexisted in perfect harmony.\n\n" +
                "Legends speak of a city hidden within lush jungles, surrounded by rivers of crystal-clear water and mountains that touch the sky. This paradise was said to be the home of wise sages and enlightened beings, who lived in harmony with the land and each other. Their knowledge was vast, encompassing the secrets of the universe and the mysteries of life itself.\n\n" +
                "But such perfection was not meant to last. Over time, the greed and ambition of men reached this tranquil haven. Wars were fought, and the balance was disrupted. The Lost Paradise faded into myth, its location forgotten, its people scattered.\n\n" +
                "Yet, the dream of this ancient utopia continues to inspire. It reminds us of the possibility of peace and the beauty that can be found when humanity lives in harmony with nature. As we search for this lost world, we also seek to rediscover the values that made it a paradise.\n\n" +
                "Today, as we explore the remnants of ancient civilizations and the ruins of lost cities, we are not just looking for physical evidence but for the spirit of a time when humanity and nature were one. The Lost Paradise of the ancient world is a beacon of hope, a reminder that such a place can exist, if only we dare to dream it.");
        post3.setTitle("The Ancient World's Lost Paradise");
        post3.setImageUrl(jpgData2);
        post3.setLocalDate(LocalDate.now());
        post3.setGenres(List.of("Horror", "Mystery"));
        postRepository.save(post3);


        Post post4 = new Post();
        post4.setUser(allUsers.get(1));
        post4.setText("In a realm where reality bends to the will of imagination, the tale of 101 Stories unfolds. This is a world where every whispered word and every spoken sentence has the power to create, to transform, and to enchant.\n\n" +
                "In the heart of this world lies a grand library, its shelves filled with books that contain the essence of countless tales. Each book is a gateway to a different adventure, a different life. Here, you can be a knight battling dragons, a detective solving impossible mysteries, or a lover lost in the throes of passion.\n\n" +
                "But these stories are not just for reading. In this magical place, they come to life. As you turn each page, the world around you changes. The walls of the library fade away, and you find yourself standing in the midst of the tale. You are no longer a reader but a participant, living and breathing the story as it unfolds.\n\n" +
                "The tale of 101 Stories is a journey through the limitless realms of imagination. It is a reminder that within each of us lies the power to create, to dream, and to live a thousand lives. As we explore these stories, we discover not just new worlds but new parts of ourselves.\n\n" +
                "So, step into the library, pick a book, and let the adventure begin. For in the world of 101 Stories, anything is possible, and every story is waiting to be told.");
        post4.setTitle("101 Stories");
        post4.setImageUrl(jpgData3);
        post4.setLocalDate(LocalDate.now());
        post4.setGenres(List.of("Thriller", "Romance"));
        postRepository.save(post4);

        Post post5 = new Post();
        post5.setUser(allUsers.get(1));
        post5.setText("In a land where reality and fantasy intertwine, there exists a portal to another world, a place of wonder and whimsy known as Wonderland. This is not the Wonderland of Alice, but a realm where the impossible becomes possible, and the ordinary transforms into the extraordinary.\n\n" +
                "Here, rivers flow with liquid gold, and mountains are crowned with emerald peaks. The air is filled with the scent of blooming flowers, and the skies are a tapestry of swirling colors. In this land, every corner holds a new adventure, every step a leap into the unknown.\n\n" +
                "The inhabitants of Wonderland are as diverse as the land itself. There are talking animals with wisdom beyond their years, plants that sing the songs of the ancient world, and beings who can bend reality with a mere thought. Each encounter is a story waiting to be told, a lesson to be learned.\n\n" +
                "For those who dare to venture into Wonderland, the journey is not just a physical one but a journey of the soul. It is a place where dreams and reality merge, where the line between the two fades into oblivion. In Wonderland, you are free to explore the depths of your imagination, to discover the magic that lies within.\n\n" +
                "As you leap into Wonderland, you leave behind the constraints of the mundane world. Here, you are free to dream, to imagine, and to become anything you desire. So take the leap, and let the wonders of this magical realm unfold before you.");
        post5.setTitle("A Jump into Wonderland");
        post5.setImageUrl(jpgData2);
        post5.setLocalDate(LocalDate.now().minusDays(1));
        post5.setGenres(List.of("Drama", "Satire"));
        postRepository.save(post5);


        Post post6 = new Post();
        post6.setUser(allUsers.get(1));
        post6.setText("In the vast expanse of the wild west, where the horizon stretches endlessly and the spirit of adventure reigns supreme, there are tales of epic journeys and daring escapades. These are the stories of those who ventured into the unknown, seeking fortune, freedom, and a life beyond the ordinary.\n\n" +
                "The rugged landscapes of the west are both beautiful and unforgiving. Towering mountains, arid deserts, and sprawling plains form the backdrop for countless adventures. Here, the brave and the bold carve out their destinies, guided by the stars and the promise of a new beginning.\n\n" +
                "Among these adventurers are cowboys and outlaws, poets and dreamers, each with a story to tell. They ride through the wilderness, driven by a relentless spirit and an unyielding desire to find their place in this untamed land. Their journeys are filled with trials and triumphs, love and loss, as they navigate the challenges of the wild west.\n\n" +
                "In the heart of this rugged frontier lies the essence of the adventure: the quest for freedom and the pursuit of dreams. It is a land where the rules are few, and the possibilities are endless. Each day brings a new challenge, a new opportunity to discover the world and oneself.\n\n" +
                "So, saddle up and join the ride. The adventures of the wild west are waiting, filled with excitement, danger, and the promise of a life lived on the edge. In this land of endless horizons, the spirit of adventure knows no bounds.");
        post6.setTitle("Adventures!!");
        post6.setImageUrl(jpgData4);
        post6.setLocalDate(LocalDate.now().minusDays(5));
        post6.setGenres(List.of("Western", "Poetry"));
        postRepository.save(post6);

        Post post7 = new Post();
        post7.setUser(allUsers.get(0));
        post7.setText("In the tapestry of history, there are creatures that have captured the imagination of mankind for centuries. These mythical beasts, born from the depths of our collective consciousness, are the stuff of legend and lore.\n\n" +
                "Among these legends is the tale of the dragon, a creature of immense power and majesty. With scales that shimmer like precious gems and breath that can incinerate the bravest of warriors, the dragon is both feared and revered. In the ancient world, dragons were seen as guardians of great treasures and secrets, beings that bridged the gap between the earthly and the divine.\n\n" +
                "Yet, the dragon is not the only mythical beast that roams the annals of history. There are griffins, with the body of a lion and the wings of an eagle, symbolizing strength and vigilance. The phoenix, a bird that rises from its own ashes, embodies the cycle of death and rebirth, a symbol of eternal renewal.\n\n" +
                "These creatures, though born from the imagination, hold a mirror to our deepest fears and desires. They represent the unknown and the untamed, the power and the mystery that lie beyond the boundaries of our everyday lives. Through them, we explore the limits of our understanding and the depths of our courage.\n\n" +
                "As we delve into the myths and legends of these creatures, we are not just uncovering tales of old but exploring the rich tapestry of human imagination. The stories of these mythical beasts continue to inspire and captivate, reminding us of the wonder and mystery that lie at the heart of our world.");
        post7.setTitle("Mythical Beast!");
        post7.setImageUrl(jpgData);
        post7.setLocalDate(LocalDate.now().minusDays(8));
        post7.setGenres(List.of("Historical", "Non-fiction"));
        postRepository.save(post7);

        Post post8 = new Post();
        post8.setUser(allUsers.get(2));
        post8.setText("In the realm of the extraordinary, there is a story of a creature whose grace and power captivate the hearts of all who behold it. This is the tale of the running animal, a symbol of freedom and untamed beauty.\n\n" +
                "This creature, swift as the wind and agile as the flowing river, embodies the spirit of the wild. With each stride, it covers vast distances, its movements a dance of elegance and strength. Its eyes, filled with the wisdom of the ages, see beyond the horizon, always looking towards the next adventure.\n\n" +
                "In its world, there are no boundaries, no constraints. The running animal roams free, its path determined only by its own will and the call of the wild. It is a reminder of the untamed spirit within each of us, the part that longs to break free from the constraints of the mundane and explore the uncharted territories of life.\n\n" +
                "As we watch this magnificent creature in its natural habitat, we are reminded of the beauty of freedom and the power of the untamed spirit. The running animal is not just a creature of the wild but a symbol of the endless possibilities that await those who dare to run towards their dreams.\n\n" +
                "In the heart of the wilderness, where the wind whispers ancient secrets and the earth beats with the rhythm of life, the running animal finds its home. It is a testament to the power of the wild and the beauty of a life lived in harmony with nature.");
        post8.setTitle("Running Animal");
        post8.setImageUrl(jpgData3);
        post8.setLocalDate(LocalDate.now().minusDays(3));
        post8.setGenres(List.of("Erotica", "Adventure"));
        postRepository.save(post8);


        Post post9 = new Post();
        post9.setUser(allUsers.get(2));
        post9.setText("In a world where speed and agility are revered, the tale of the fast running hero stands as a testament to the power of human will and determination. This is the story of one who could outrun the wind and defy the limits of the human body.\n\n" +
                "From a young age, our hero was fascinated by the idea of speed. Every day was a race against time, a challenge to go faster, to push the boundaries of what was possible. With each step, they felt the rush of adrenaline, the thrill of the chase, and the exhilaration of surpassing their own limits.\n\n" +
                "As they grew, so did their speed. They became a legend in their own right, known far and wide for their ability to cover vast distances in the blink of an eye. Their feats were not just of physical prowess but of mental fortitude, a testament to the power of perseverance and the human spirit.\n\n" +
                "But speed was not just about the physical act of running. For our hero, it was a way of life, a philosophy that guided their every action. It was about seizing the moment, living life at full throttle, and never looking back. Each race, each challenge, was a step towards a greater understanding of themselves and the world around them.\n\n" +
                "The tale of the fast running hero is a reminder that speed is not just about how fast we move but about how we live our lives. It is about embracing the journey, pushing beyond our limits, and running towards our dreams with unwavering determination.");
        post9.setTitle("Fast Running");
        post9.setImageUrl(jpgData2);
        post9.setLocalDate(LocalDate.now().minusDays(2));
        post9.setGenres(List.of("Satire", "Adventure"));
        postRepository.save(post9);

        Post post10 = new Post();
        post10.setUser(allUsers.get(2));
        post10.setText("In a world where the line between life and death is as thin as a breath, the story of 'The Dying Human' unfolds. This is a tale of struggle and resilience, of the fragile beauty of life and the inevitability of death.\n\n" +
                "Our protagonist, a mortal like any other, is faced with the ultimate challenge: the fight for life in the face of impending death. Each day is a battle, each breath a precious gift. As the shadow of mortality looms ever closer, they reflect on the life they have lived, the choices they have made, and the moments that have defined their existence.\n\n" +
                "In the midst of their struggle, they find strength in the simplest of things. The warmth of the sun on their face, the sound of laughter, the touch of a loved one. These moments, fleeting and fragile, become their anchors in the storm of their illness. They are reminders of the beauty of life, even in its darkest hours.\n\n" +
                "As the end draws near, our protagonist faces their mortality with courage and grace. They come to accept the inevitable, finding peace in the knowledge that death is not an end but a transition. It is a return to the unknown, a journey to whatever lies beyond the veil of life.\n\n" +
                "The story of 'The Dying Human' is a poignant reminder of the fragility of life and the strength of the human spirit. It is a testament to the power of hope, love, and the enduring will to live, even in the face of death.");
        post10.setTitle("The Dying Human");
        post10.setImageUrl(jpgData4);
        post10.setLocalDate(LocalDate.now().minusDays(7));
        post10.setGenres(List.of("Erotica", "Horror"));
        postRepository.save(post10);
    }

}
