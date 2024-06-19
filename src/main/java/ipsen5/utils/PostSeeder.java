package ipsen5.utils;

import ipsen5.models.enums.PrefferedDestination;
import ipsen5.repository.PostRepository;
import ipsen5.repository.UserRepository;
import ipsen5.models.Post;
import ipsen5.models.User;
import org.springframework.stereotype.Component;

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

    public void seedPost(){
        List<User> allUsers = userRepository.findAll();
        Post post1 = new Post();
        post1.setUser(allUsers.get(0));
        post1.setText("In the annals of history, Babylon stands as a beacon of ancient marvels. Among these, the Hanging Gardens have long captivated the imagination of scholars and adventurers alike. Yet, the truth behind these verdant wonders is a tapestry woven with both myth and reality.\n\n" +
                "Nimrod, the fabled king and hunter, is said to have founded Babylon with the blessings of the gods. His vision was not merely for a city but for a utopia, a place where the heavens and earth could meet. The Hanging Gardens were the epitome of this dream. Constructed as a towering ziggurat, the gardens cascaded down in lush terraces, each one a step closer to the divine.\n\n" +
                "Built to please his wife, Amytis, who longed for the green hills of her homeland, these gardens were a marvel of engineering. Watered by an ingenious irrigation system that defied the arid climate, they were a symbol of man's ability to conquer nature. Yet, they were also a testament to the delicate balance between humanity and the divine.\n\n" +
                "As the centuries passed, the Hanging Gardens became more than just a symbol of love and power. They were a reminder of Babylon's grandeur and its fall. Each leaf, each flower, whispered tales of a time when gods walked among men, and the boundaries of what was possible were continually pushed.\n\n" +
                "Today, as we delve into the ruins and unravel the secrets buried beneath the sands, we rediscover not just a lost wonder but a lesson. The Hanging Gardens of Babylon are a testament to human ingenuity and the eternal quest to reach beyond our grasp, to touch the divine, if only for a fleeting moment.");
        post1.setTitle("Rediscovering Babylon: The Truth Behind the Hanging Gardens");
        post1.setImageUrl("https://escapewelt.com/image/catalog/products/v.3/QuestTower/Landing/01.jpg");
        post1.setLocalDate(LocalDate.now());
        post1.setPrefferedDestination(PrefferedDestination.OFFICIAL_SELECTION);
        post1.setGenres(List.of("Fantasy", "Adventure"));
        postRepository.save(post1);

        Post post2 = new Post();
        post2.setUser(allUsers.get(0));
        post2.setText("In a world where the line between reality and fantasy blurs, the verdant wonders of the earth hold secrets that defy comprehension. These enigmatic landscapes are not merely beautiful; they are gateways to realms of the unknown.\n\n" +
                "Take, for instance, the lush rainforests that blanket our planet's equator. These green havens are teeming with life, each leaf and vine a thread in the intricate web of existence. Yet, beneath their emerald canopy lies a world of mystery and wonder. Ancient trees, their roots intertwined with time itself, guard secrets older than human civilization.\n\n" +
                "One such legend speaks of the lost city of El Dorado, hidden deep within the Amazon rainforest. This city of gold, its streets paved with the shimmering metal, is said to hold untold treasures and wisdom. But it is not the gold that draws explorers; it is the promise of the unknown. For El Dorado is not just a city; it is a beacon of mankind's insatiable curiosity, a symbol of the quest to uncover the hidden wonders of our world.\n\n" +
                "As we journey through these verdant realms, we are reminded of our place in the grand tapestry of life. The forests, with their ancient wisdom, teach us that there is more to the world than meets the eye. They beckon us to explore, to dream, and to believe in the enigmatic wonders that lie just beyond the horizon.");
        post2.setTitle("Verdant Wonders: Exploring the Enigmatic");
        post2.setImageUrl("https://cdn.openart.ai/stable_diffusion/171ddbee400feccf4e534dc4a85bd4b4c633b9a7_2000x2000.webp");
        post2.setLocalDate(LocalDate.now().minusDays(9));
        post2.setPrefferedDestination(PrefferedDestination.BABELs_CHOICE);
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
        post3.setImageUrl("https://img.freepik.com/premium-photo/mythical-creatures-fairytale-landscapes-magical-symbols-together-generative-ai_830962-3645.jpg");
        post3.setLocalDate(LocalDate.now());
        post3.setGenres(List.of("Horror", "Mystery"));
        post3.setPrefferedDestination(PrefferedDestination.OFFICIAL_SELECTION);
        postRepository.save(post3);

        Post post4 = new Post();
        post4.setUser(allUsers.get(1));
        post4.setText("In a realm where reality bends to the will of imagination, the tale of 101 Stories unfolds. This is a world where every whispered word and every spoken sentence has the power to create, to transform, and to enchant.\n\n" +
                "In the heart of this world lies a grand library, its shelves filled with books that contain the essence of countless tales. Each book is a gateway to a different adventure, a different life. Here, you can be a knight battling dragons, a detective solving impossible mysteries, or a lover lost in the throes of passion.\n\n" +
                "But these stories are not just for reading. In this magical place, they come to life. As you turn each page, the world around you changes. The walls of the library fade away, and you find yourself standing in the midst of the tale. You are no longer a reader but a participant, living and breathing the story as it unfolds.\n\n" +
                "The tale of 101 Stories is a journey through the limitless realms of imagination. It is a reminder that within each of us lies the power to create, to dream, and to live a thousand lives. As we explore these stories, we discover not just new worlds but new parts of ourselves.\n\n" +
                "So, step into the library, pick a book, and let the adventure begin. For in the world of 101 Stories, anything is possible, and every story is waiting to be told.");
        post4.setTitle("101 Stories");
        post4.setImageUrl("https://i.pinimg.com/736x/42/04/c6/4204c696523e94019d819ae8f6455011.jpg");
        post4.setLocalDate(LocalDate.now());
        post4.setGenres(List.of("Thriller", "Romance"));
        post4.setPrefferedDestination(PrefferedDestination.SANDBOX);
        postRepository.save(post4);

        Post post5 = new Post();
        post5.setUser(allUsers.get(1));
        post5.setText("In a land where reality and fantasy intertwine, there exists a portal to another world, a place of wonder and whimsy known as Wonderland. This is not the Wonderland of Alice, but a realm where the impossible becomes possible, and the ordinary transforms into the extraordinary.\n\n" +
                "Here, rivers flow with liquid gold, and mountains are crowned with emerald peaks. The air is filled with the scent of blooming flowers, and the skies are a tapestry of swirling colors. In this land, every corner holds a new adventure, every step a leap into the unknown.\n\n" +
                "The inhabitants of Wonderland are as diverse as the land itself. There are talking animals with wisdom beyond their years, plants that sing the songs of the ancient world, and beings who can bend reality with a mere thought. Each encounter is a story waiting to be told, a lesson to be learned.\n\n" +
                "For those who dare to venture into Wonderland, the journey is not just a physical one but a journey of the soul. It is a place where dreams and reality merge, where the line between the two fades into oblivion. In Wonderland, you are free to explore the depths of your imagination, to discover the magic that lies within.\n\n" +
                "As you leap into Wonderland, you leave behind the constraints of the mundane world. Here, you are free to dream, to imagine, and to become anything you desire. So take the leap, and let the wonders of this magical realm unfold before you.");
        post5.setTitle("A Jump into Wonderland");
        post5.setImageUrl("https://static.vecteezy.com/system/resources/previews/030/605/983/large_2x/fantasy-night-landscape-with-magical-power-ancient-stones-with-magical-power-and-light-runes-passage-to-another-world-magic-door-light-neon-ai-generative-free-photo.jpg");
        post5.setLocalDate(LocalDate.now().minusDays(1));
        post5.setGenres(List.of("Drama", "Satire"));
        post5.setPrefferedDestination(PrefferedDestination.OFFICIAL_SELECTION);
        postRepository.save(post5);


        Post post6 = new Post();
        post6.setUser(allUsers.get(1));
        post6.setText("In the vast expanse of the wild west, where the horizon stretches endlessly and the spirit of adventure reigns supreme, there are tales of epic journeys and daring escapades. These are the stories of those who ventured into the unknown, seeking fortune, freedom, and a life beyond the ordinary.\n\n" +
                "The rugged landscapes of the west are both beautiful and unforgiving. Towering mountains, arid deserts, and sprawling plains form the backdrop for countless adventures. Here, the brave and the bold carve out their destinies, guided by the stars and the promise of a new beginning.\n\n" +
                "Among these adventurers are cowboys and outlaws, poets and dreamers, each with a story to tell. They ride through the wilderness, driven by a relentless spirit and an unyielding desire to find their place in this untamed land. Their journeys are filled with trials and triumphs, love and loss, as they navigate the challenges of the wild west.\n\n" +
                "In the heart of this rugged frontier lies the essence of the adventure: the quest for freedom and the pursuit of dreams. It is a land where the rules are few, and the possibilities are endless. Each day brings a new challenge, a new opportunity to discover the world and oneself.\n\n" +
                "So, saddle up and join the ride. The adventures of the wild west are waiting, filled with excitement, danger, and the promise of a life lived on the edge. In this land of endless horizons, the spirit of adventure knows no bounds.");
        post6.setTitle("Adventures!!");
        post6.setImageUrl("https://www.creativefabrica.com/wp-content/uploads/2022/09/29/Labyrinth-Of-Minos-Greek-Myth-Landscape-By-Guido-Borel-39539484-1.png");
        post6.setLocalDate(LocalDate.now().minusDays(5));
        post6.setGenres(List.of("Western", "Poetry"));
        post6.setPrefferedDestination(PrefferedDestination.BABELs_CHOICE);
        postRepository.save(post6);

        Post post7 = new Post();
        post7.setUser(allUsers.get(0));
        post7.setText("In the tapestry of history, there are creatures that have captured the imagination of mankind for centuries. These mythical beasts, born from the depths of our collective consciousness, are the stuff of legend and lore.\n\n" +
                "Among these legends is the tale of the dragon, a creature of immense power and majesty. With scales that shimmer like precious gems and breath that can incinerate the bravest of warriors, the dragon is both feared and revered. In the ancient world, dragons were seen as guardians of great treasures and secrets, beings that bridged the gap between the earthly and the divine.\n\n" +
                "Yet, the dragon is not the only mythical beast that roams the annals of history. There are griffins, with the body of a lion and the wings of an eagle, symbolizing strength and vigilance. The phoenix, a bird that rises from its own ashes, embodies the cycle of death and rebirth, a symbol of eternal renewal.\n\n" +
                "These creatures, though born from the imagination, hold a mirror to our deepest fears and desires. They represent the unknown and the untamed, the power and the mystery that lie beyond the boundaries of our everyday lives. Through them, we explore the limits of our understanding and the depths of our courage.\n\n" +
                "As we delve into the myths and legends of these creatures, we are not just uncovering tales of old but exploring the rich tapestry of human imagination. The stories of these mythical beasts continue to inspire and captivate, reminding us of the wonder and mystery that lie at the heart of our world.");
        post7.setTitle("Mythical Beast!");
        post7.setImageUrl("https://i.pinimg.com/736x/2c/a7/29/2ca729e1c15bacbb9aad9797cf6fb323.jpg");
        post7.setLocalDate(LocalDate.now().minusDays(8));
        post7.setGenres(List.of("Historical", "Non-fiction"));
        post7.setPrefferedDestination(PrefferedDestination.SANDBOX);
        postRepository.save(post7);

        Post post8 = new Post();
        post8.setUser(allUsers.get(2));
        post8.setText("In the realm of the extraordinary, there is a story of a creature whose grace and power captivate the hearts of all who behold it. This is the tale of the running animal, a symbol of freedom and untamed beauty.\n\n" +
                "This creature, swift as the wind and agile as the flowing river, embodies the spirit of the wild. With each stride, it covers vast distances, its movements a dance of elegance and strength. Its eyes, filled with the wisdom of the ages, see beyond the horizon, always looking towards the next adventure.\n\n" +
                "In its world, there are no boundaries, no constraints. The running animal roams free, its path determined only by its own will and the call of the wild. It is a reminder of the untamed spirit within each of us, the part that longs to break free from the constraints of the mundane and explore the uncharted territories of life.\n\n" +
                "As we watch this magnificent creature in its natural habitat, we are reminded of the beauty of freedom and the power of the untamed spirit. The running animal is not just a creature of the wild but a symbol of the endless possibilities that await those who dare to run towards their dreams.\n\n" +
                "In the heart of the wilderness, where the wind whispers ancient secrets and the earth beats with the rhythm of life, the running animal finds its home. It is a testament to the power of the wild and the beauty of a life lived in harmony with nature.");
        post8.setTitle("Running Animal");
        post8.setImageUrl("https://images2.alphacoders.com/249/249810.jpg");
        post8.setLocalDate(LocalDate.now().minusDays(3));
        post8.setGenres(List.of("Erotica", "Adventure"));
        post8.setPrefferedDestination(PrefferedDestination.BABELs_CHOICE);
        postRepository.save(post8);

        Post post9 = new Post();
        post9.setUser(allUsers.get(2));
        post9.setText("In a world where speed and agility are revered, the tale of the fast running hero stands as a testament to the power of human will and determination. This is the story of one who could outrun the wind and defy the limits of the human body.\n\n" +
                "From a young age, our hero was fascinated by the idea of speed. Every day was a race against time, a challenge to go faster, to push the boundaries of what was possible. With each step, they felt the rush of adrenaline, the thrill of the chase, and the exhilaration of surpassing their own limits.\n\n" +
                "As they grew, so did their speed. They became a legend in their own right, known far and wide for their ability to cover vast distances in the blink of an eye. Their feats were not just of physical prowess but of mental fortitude, a testament to the power of perseverance and the human spirit.\n\n" +
                "But speed was not just about the physical act of running. For our hero, it was a way of life, a philosophy that guided their every action. It was about seizing the moment, living life at full throttle, and never looking back. Each race, each challenge, was a step towards a greater understanding of themselves and the world around them.\n\n" +
                "The tale of the fast running hero is a reminder that speed is not just about how fast we move but about how we live our lives. It is about embracing the journey, pushing beyond our limits, and running towards our dreams with unwavering determination.");
        post9.setTitle("Fast Running");
        post9.setImageUrl("https://img.freepik.com/free-photo/mountain-landscape-with-fantasy-style-scene_23-2151125180.jpg");
        post9.setLocalDate(LocalDate.now().minusDays(2));
        post9.setGenres(List.of("Satire", "Adventure"));
        post9.setPrefferedDestination(PrefferedDestination.OFFICIAL_SELECTION);
        postRepository.save(post9);

        Post post10 = new Post();
        post10.setUser(allUsers.get(2));
        post10.setText("In a world where the line between life and death is as thin as a breath, the story of 'The Dying Human' unfolds. This is a tale of struggle and resilience, of the fragile beauty of life and the inevitability of death.\n\n" +
                "Our protagonist, a mortal like any other, is faced with the ultimate challenge: the fight for life in the face of impending death. Each day is a battle, each breath a precious gift. As the shadow of mortality looms ever closer, they reflect on the life they have lived, the choices they have made, and the moments that have defined their existence.\n\n" +
                "In the midst of their struggle, they find strength in the simplest of things. The warmth of the sun on their face, the sound of laughter, the touch of a loved one. These moments, fleeting and fragile, become their anchors in the storm of their illness. They are reminders of the beauty of life, even in its darkest hours.\n\n" +
                "As the end draws near, our protagonist faces their mortality with courage and grace. They come to accept the inevitable, finding peace in the knowledge that death is not an end but a transition. It is a return to the unknown, a journey to whatever lies beyond the veil of life.\n\n" +
                "The story of 'The Dying Human' is a poignant reminder of the fragility of life and the strength of the human spirit. It is a testament to the power of hope, love, and the enduring will to live, even in the face of death.");
        post10.setTitle("The Dying Human");
        post10.setImageUrl("https://cdna.artstation.com/p/assets/images/images/060/567/946/large/joshua-jackson-blablo3450-a-whimsical-fantastical-world-inhabited-by-mythical-56ce79bb-3ac4-4439-827d-0f5fe1c13dd8.jpg?1678853242");
        post10.setLocalDate(LocalDate.now().minusDays(7));
        post10.setGenres(List.of("Erotica", "Horror"));
        post10.setPrefferedDestination(PrefferedDestination.SANDBOX);
        postRepository.save(post10);

        Post post11 = new Post();
        post11.setUser(allUsers.get(1));
        post11.setText("In the heart of the enchanted forest, there lies a realm untouched by time, where the fairies dance under the silver light of the moon. This is the story of the Fairy Queen, a being of ethereal beauty and ancient magic.\n\n" +
                "With wings that sparkle like the morning dew and a voice that echoes like a gentle breeze, the Fairy Queen rules her domain with grace and wisdom. Her subjects, creatures of light and shadow, look to her for guidance in times of joy and sorrow.\n\n" +
                "The Fairy Queen's power is rooted in the very essence of the forest. Her magic nurtures the trees, brings forth the blooms, and calls forth the rain. She is the guardian of nature's balance, ensuring that every living thing thrives in harmony.\n\n" +
                "Through her, we see the delicate interplay between strength and gentleness, power and compassion. The Fairy Queen reminds us that true leadership is about nurturing those we lead and protecting the beauty and balance of our world.\n\n" +
                "In the tales of the Fairy Queen, we find inspiration to seek harmony in our own lives, to cherish the natural world, and to embrace the magic that resides within us all.");
        post11.setTitle("The Fairy Queen");
        post11.setImageUrl("https://www.kunstkopie.nl/kunst/pierre_henri_de_valenciennes/Landscape-of-Ancient-Greece.jpg");
        post11.setLocalDate(LocalDate.now().minusDays(10));
        post11.setGenres(List.of("Fantasy", "Romance"));
        post11.setPrefferedDestination(PrefferedDestination.BABELs_CHOICE);
        postRepository.save(post11);

        Post post12 = new Post();
        post12.setUser(allUsers.get(2));
        post12.setText("Beneath the waves, in the shadowy depths of the ocean, lies a kingdom as vast and mysterious as the night sky. This is the domain of the Sea Serpent, a creature of myth and legend, feared and revered by sailors for centuries.\n\n" +
                "With a body that glides through the water like a ribbon of darkness and eyes that gleam with an ancient wisdom, the Sea Serpent commands the ocean's depths. It is said to guard the treasures of the deep and to possess knowledge of the secrets hidden beneath the waves.\n\n" +
                "The Sea Serpent embodies the dual nature of the sea itself: serene and beautiful, yet capable of unleashing untold fury. It represents the mystery of the unknown and the fear that lies in the dark corners of our imagination.\n\n" +
                "In its presence, we are reminded of the vastness of the world and the power of the forces that shape it. The Sea Serpent challenges us to confront our fears and to explore the depths of our own courage and curiosity.\n\n" +
                "Through the legends of the Sea Serpent, we are drawn to the wonders of the ocean and the boundless mysteries that it holds, urging us to dive deeper into the unknown.");
        post12.setTitle("The Sea Serpent");
        post12.setImageUrl("https://wallpapers.com/images/hd/mythical-1920-x-1080-background-d8fegyij9fleni0b.jpg");
        post12.setLocalDate(LocalDate.now().minusDays(6));
        post12.setGenres(List.of("Mystery", "Adventure"));
        post12.setPrefferedDestination(PrefferedDestination.SANDBOX);
        postRepository.save(post12);

        Post post13 = new Post();
        post13.setUser(allUsers.get(1));
        post13.setText("High in the mountains, where the air is thin and the peaks kiss the sky, there lives a creature of strength and majesty. This is the tale of the Mountain Giant, a being of immense power and timeless wisdom.\n\n" +
                "With limbs as strong as the ancient oaks and a heart as deep as the earth itself, the Mountain Giant roams the rugged landscape. Its footsteps echo through the valleys, a reminder of the might of nature's forces.\n\n" +
                "The Mountain Giant is a guardian of the high places, protecting the fragile beauty of the alpine world. It watches over the flora and fauna, ensuring that life flourishes even in the harshest conditions.\n\n" +
                "In the story of the Mountain Giant, we see a reflection of the strength and resilience that lie within us. It teaches us that even in the face of overwhelming challenges, we can stand tall and weather the storms.\n\n" +
                "Through the legend of the Mountain Giant, we are inspired to seek out the heights in our own lives, to find our inner strength, and to appreciate the beauty and power of the natural world.");
        post13.setTitle("The Mountain Giant");
        post13.setImageUrl("https://cdn.openart.ai/stable_diffusion/658569d4129fbded20333bf7ba658db35938bf99_2000x2000.webp");
        post13.setLocalDate(LocalDate.now().minusDays(5));
        post13.setGenres(List.of("Mythology", "Inspirational"));
        post13.setPrefferedDestination(PrefferedDestination.OFFICIAL_SELECTION);
        postRepository.save(post13);

        Post post14 = new Post();
        post14.setUser(allUsers.get(0));
        post14.setText("In the twilight hours, when the boundary between day and night blurs, the Shadow Walker emerges. This is the story of a creature that moves through the darkness, unseen and unknown, a phantom of the night.\n\n" +
                "With eyes that pierce the deepest shadows and a form that shifts with the flicker of the moonlight, the Shadow Walker is a master of stealth. It navigates the night with a grace that is both eerie and captivating.\n\n" +
                "The Shadow Walker is a being of mystery, embodying the fear of the unseen and the allure of the hidden. It represents the unknown forces that move in the dark, beyond the reach of our understanding.\n\n" +
                "In the presence of the Shadow Walker, we are reminded of the hidden aspects of our own nature, the parts of ourselves that we keep in the shadows. It challenges us to confront these hidden truths and to explore the depths of our own souls.\n\n" +
                "Through the legend of the Shadow Walker, we are drawn into the mysteries of the night, exploring the realms of the unseen and the unknown, and finding the courage to face the darkness within.");
        post14.setTitle("The Shadow Walker");
        post14.setImageUrl("https://i.seadn.io/gae/FGxFFkeUuECAIJ_vwa0PmC08Pb0MZv-nCIpqdLlRIF6rSLAkcdn0umjydCDmPZb5GlJKjhLAuhMyJXbNFdbjSxN6Iae673MgLjv2LQ?auto=format&dpr=1&w=1000");
        post14.setLocalDate(LocalDate.now().minusDays(4));
        post14.setGenres(List.of("Thriller", "Fantasy"));
        post14.setPrefferedDestination(PrefferedDestination.BABELs_CHOICE);
        postRepository.save(post14);

        Post post15 = new Post();
        post15.setUser(allUsers.get(1));
        post15.setText("In the golden glow of dawn, where the first light touches the earth, the Phoenix rises. This is the tale of a bird born from the ashes, a symbol of rebirth and renewal.\n\n" +
                "With feathers that blaze like the sun and a cry that echoes across the skies, the Phoenix soars high above, a beacon of hope and transformation. Its flight is a dance of flames, a testament to the power of renewal.\n\n" +
                "The Phoenix embodies the cycle of life and death, the eternal process of transformation that governs all things. It is a reminder that from the ashes of the old, the new can always arise.\n\n" +
                "In the legend of the Phoenix, we find inspiration to embrace change and to find strength in our ability to renew and transform. It teaches us that no matter how dark the night, the dawn will always come.\n\n" +
                "Through the story of the Phoenix, we are encouraged to rise from our own challenges, to find the fire within, and to embrace the endless possibilities of a new beginning.");
        post15.setTitle("The Phoenix Rising");
        post15.setImageUrl("https://www.ancient-origins.net/sites/default/files/field/image/mythical-creatures.jpg");
        post15.setLocalDate(LocalDate.now().minusDays(1));
        post15.setGenres(List.of("Fantasy", "Inspirational"));
        post15.setPrefferedDestination(PrefferedDestination.OFFICIAL_SELECTION);
        postRepository.save(post15);

        Post post16 = new Post();
        post16.setUser(allUsers.get(2));
        post16.setText("In the icy reaches of the far north, where the auroras dance across the night sky, lives a creature of ancient majesty. This is the story of the Ice Dragon, a beast of frost and legend.\n\n" +
                "With scales that glisten like frozen stars and breath that chills the air, the Ice Dragon is a master of the winter realms. It roams the glaciers and snowy peaks, its presence a testament to the raw power of the cold.\n\n" +
                "The Ice Dragon embodies the harsh beauty of the frozen wilderness. It represents the strength and resilience needed to survive in the most unforgiving environments.\n\n" +
                "In its icy domain, the Ice Dragon challenges us to find our own inner strength, to endure the coldest trials, and to emerge stronger and more determined.\n\n" +
                "Through the legends of the Ice Dragon, we are reminded of the power and beauty of the natural world, and the strength that lies within us to conquer any adversity.");
        post16.setTitle("The Ice Dragon");
        post16.setImageUrl("https://www.stairsainty.com/wp-content/uploads/2016/03/classical-greek-landscape-with-girls-sacrificing-their-hair-to-diana-on-the-bank-of-a-river.jpg");
        post16.setLocalDate(LocalDate.now().minusDays(11));
        post16.setGenres(List.of("Fantasy", "Adventure"));
        post16.setPrefferedDestination(PrefferedDestination.SANDBOX);
        postRepository.save(post16);

        Post post17 = new Post();
        post17.setUser(allUsers.get(0));
        post17.setText("In the heart of the desert, under the scorching sun and shifting sands, there lives a creature of endurance and mystery. This is the story of the Desert Wanderer, a mythical beast that roams the vast dunes.\n\n" +
                "With eyes that can see through the blinding sandstorms and a body that withstands the harshest heat, the Desert Wanderer is a master of survival. It moves with grace across the arid landscape, a symbol of resilience and adaptation.\n\n" +
                "The Desert Wanderer represents the strength required to navigate life's toughest challenges. It teaches us the importance of persistence and the ability to thrive even in the most difficult circumstances.\n\n" +
                "In its journey through the endless desert, the Desert Wanderer inspires us to embrace our own paths, no matter how arduous, and to find strength in our ability to endure.\n\n" +
                "Through the stories of the Desert Wanderer, we are reminded of the beauty and power of perseverance, and the boundless capacity for resilience within us all.");
        post17.setTitle("The Desert Wanderer");
        post17.setImageUrl("https://cdn.openart.ai/stable_diffusion/da1b74ecba09cef06317cdcb0b7385f0dc8aac01_2000x2000.webp");
        post17.setLocalDate(LocalDate.now().minusDays(9));
        post17.setGenres(List.of("Adventure", "Inspirational"));
        post17.setPrefferedDestination(PrefferedDestination.BABELs_CHOICE);
        postRepository.save(post17);

        Post post18 = new Post();
        post18.setUser(allUsers.get(1));
        post18.setText("In the quiet corners of the enchanted woods, where the light filters through the leaves in a magical dance, there is a creature of wisdom and tranquility. This is the story of the Forest Guardian, a protector of nature’s secrets.\n\n" +
                "With antlers that rise like the ancient trees and eyes that reflect the depths of the forest, the Forest Guardian watches over the woodland creatures and the delicate balance of life.\n\n" +
                "The Forest Guardian embodies the harmony and peace found in the natural world. It reminds us of the importance of protecting and cherishing the environment that sustains us.\n\n" +
                "In the presence of the Forest Guardian, we are called to reconnect with nature, to find solace in its beauty, and to respect the intricate web of life that surrounds us.\n\n" +
                "Through the tales of the Forest Guardian, we are inspired to become stewards of the earth, to safeguard the precious ecosystems, and to nurture the world for future generations.");
        post18.setTitle("The Forest Guardian");
        post18.setImageUrl("https://as2.ftcdn.net/v2/jpg/05/62/87/35/1000_F_562873570_etl5RBJjQT0FsbWqKh2KI3frcTqUPwYa.jpg");
        post18.setLocalDate(LocalDate.now().minusDays(8));
        post18.setGenres(List.of("Fantasy", "Environmental"));
        post18.setPrefferedDestination(PrefferedDestination.OFFICIAL_SELECTION);
        postRepository.save(post18);

        Post post19 = new Post();
        post19.setUser(allUsers.get(2));
        post19.setText("In the shimmering heat of the savannah, where the golden grass waves like a sea, there prowls a creature of elegance and power. This is the story of the Lioness Queen, a symbol of grace and strength.\n\n" +
                "With a stride that speaks of regal authority and a gaze that commands respect, the Lioness Queen rules over her domain with a blend of fierceness and maternal care. She is the heart of the pride, the protector and the provider.\n\n" +
                "The Lioness Queen represents the duality of power and nurturing, showing us that true strength lies in the balance of force and compassion.\n\n" +
                "In her role, the Lioness Queen teaches us the value of leadership, the importance of caring for our communities, and the power of unity and cooperation.\n\n" +
                "Through the story of the Lioness Queen, we are reminded to embrace our own power, to lead with kindness, and to find strength in our connections with others.");
        post19.setTitle("The Lioness Queen");
        post19.setImageUrl("https://img.freepik.com/premium-photo/full-moon-dark-fantasy-landscape_776674-198200.jpg");
        post19.setLocalDate(LocalDate.now().minusDays(7));
        post19.setGenres(List.of("Adventure", "Leadership"));
        post19.setPrefferedDestination(PrefferedDestination.SANDBOX);
        postRepository.save(post19);

        Post post20 = new Post();
        post20.setUser(allUsers.get(1));
        post20.setText("In the ancient ruins of forgotten civilizations, where time has eroded the grandeur of empires, there resides a creature of profound mystery. This is the story of the Stone Sentinel, a guardian of lost secrets.\n\n" +
                "With a form carved from the very rock of the earth and eyes that have seen centuries pass, the Stone Sentinel stands vigil over the remnants of the past. Its presence is a bridge between the world that was and the world that is.\n\n" +
                "The Stone Sentinel symbolizes the endurance of history and the lessons embedded in the ruins of bygone eras. It reminds us to look to the past to understand the present and to build a future with the wisdom we gather.\n\n" +
                "In the shadow of the Stone Sentinel, we are encouraged to cherish the heritage of humanity, to honor the stories that have shaped us, and to protect the legacies we leave behind.\n\n" +
                "Through the legend of the Stone Sentinel, we find the importance of memory and the enduring strength of the human spirit as it weaves the tapestry of history.");
        post20.setTitle("The Stone Sentinel");
        post20.setImageUrl("https://avid-archer.com/wp-content/uploads/2023/12/legendary-archery-mythology-1140x651.webp");
        post20.setLocalDate(LocalDate.now().minusDays(6));
        post20.setGenres(List.of("Historical", "Mystery"));
        post20.setPrefferedDestination(PrefferedDestination.BABELs_CHOICE);
        postRepository.save(post20);

        Post post21 = new Post();
        post21.setUser(allUsers.get(2));
        post21.setText("In the twilight sky, where the last light of day meets the deep blue of night, there soars a creature of ethereal beauty. This is the story of the Sky Dancer, a bird of elegance and grace.\n\n" +
                "With wings that shimmer like the stars and a song that enchants all who hear it, the Sky Dancer glides through the air, a living poem of movement and melody.\n\n" +
                "The Sky Dancer represents the freedom and joy found in the simplest of life's moments. It reminds us to embrace the beauty around us and to find happiness in the everyday wonders of the world.\n\n" +
                "In its flight, the Sky Dancer inspires us to soar beyond our limitations, to explore the skies of our potential, and to find our own rhythm in the dance of life.\n\n" +
                "Through the story of the Sky Dancer, we are encouraged to live with grace and to find the poetry in our own journeys, celebrating the beauty and joy that life offers.");
        post21.setTitle("The Sky Dancer");
        post21.setImageUrl("https://media.istockphoto.com/id/887259720/photo/fantasy-tree-house.jpg?s=612x612&w=0&k=20&c=268Jkh8w5SQsxRmi8KEW3swjhRYesvfN_1T_KBGNtSE=");
        post21.setLocalDate(LocalDate.now().minusDays(5));
        post21.setGenres(List.of("Fantasy", "Inspirational"));
        post21.setPrefferedDestination(PrefferedDestination.OFFICIAL_SELECTION);
        postRepository.save(post21);

    }

}
