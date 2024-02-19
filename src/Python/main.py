from PIL import Image

w_min, w_max = 190, 255

colors = ["white", "light_gray", "gray", "black", "brown", "red", "orange", "yellow", "lime", "green", "cyan",
          "light_blue", "blue", "purple", "magenta", "pink"]


def generate_texture(base_texture, color, save_file):
    colored_wool_extrema = Image.open("textures/wool/BlockSprite_" + color + "-wool.webp").getextrema()
    result = base_texture.copy()
    x_max, y_max = base_texture.size
    for x in range(x_max):
        for y in range(y_max):
            pixel = list(result.getpixel((x, y)))
            # check if pixel is not transparent nor very dark
            if pixel[3] > 0 and pixel[0] > 100:
                for component in range(3):
                    c_min, c_max = colored_wool_extrema[component]
                    initial_value = pixel[component]
                    pixel[component] = int(c_min + (initial_value - w_min) * (c_max - c_min) / (w_max - w_min))
                result.putpixel((x, y), (pixel[0], pixel[1], pixel[2], pixel[3]))

    result.save(save_file)


def generate_feather_block_textures(save_path):
    base_texture = Image.open("textures/featherBlocks/FeatherBlockBaseTexture.png")
    for color in colors:
        generate_texture(base_texture, color, save_path + color + "_feather_block.png")


def generate_feather_textures(save_path):
    base_texture = Image.open("textures/feathers/ItemSprite_feather.webp")
    for color in colors:
        if color != "white":
            generate_texture(base_texture, color, save_path + color + "_feather.png")


def generate_feather_armors(save_path):
    for armor_type in ["helmet", "chestplate", "leggings", "boots", "winged_boots", "layer_1", "layer_2"]:
        base_texture = Image.open("textures/featherArmor/base_feather_" + armor_type + ".png")
        for color in colors:
            save_path_addition = "models/armor/" if armor_type in ["layer_1", "layer_2"] else "item/"
            full_save_path = save_path + save_path_addition + color + "_feather_" + armor_type + ".png"
            generate_texture(base_texture, color, full_save_path)


# generate_feather_block_textures("../main/resources/assets/birds_and_feathers/textures/block/")
# generate_feather_textures("textures/test_save/")
generate_feather_armors("../main/resources/assets/birds_and_feathers/textures/")

