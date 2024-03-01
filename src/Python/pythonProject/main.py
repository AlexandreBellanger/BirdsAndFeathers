from PIL import Image

w_min, w_max = 190, 255

colors = ["white", "light_gray", "gray", "black", "brown", "red", "orange", "yellow", "lime", "green", "cyan",
          "light_blue", "blue", "purple", "magenta", "pink"]


def generate_colored_texture(base_texture, color, save_file):
    colored_wool_extrema = Image.open("textures/wool/BlockSprite_" + color + "-wool.webp").getextrema()

    result = base_texture.copy()
    alter_texture(result, 100, 255, colored_texture_alteration_function, colored_wool_extrema)

    result.save(save_file)


def alter_texture(texture, min_brightness, max_brightness, alteration_function, params=None):
    x_max, y_max = texture.size
    for x in range(x_max):
        for y in range(y_max):
            pixel = list(texture.getpixel((x, y)))
            if len(pixel) < 4:
                pixel.append(255)
            # check if pixel is not transparent out of brightness range
            if pixel[3] > 0 and min_brightness <= pixel[0] <= max_brightness:
                alteration_function(pixel, params)
                texture.putpixel((x, y), (pixel[0], pixel[1], pixel[2], pixel[3]))


def colored_texture_alteration_function(pixel, colored_wool_extrema):
    for component in range(3):
        c_min, c_max = colored_wool_extrema[component]
        initial_value = pixel[component]
        pixel[component] = int(c_min + (initial_value - w_min) * (c_max - c_min) / (w_max - w_min))


def whiten_crow_pixel(pixel, _):
    for component in range(3):
        initial_value = pixel[component]
        pixel[component] = int(10 + (initial_value - 5) * (80 - 10) / (50 - 5))


def generate_feather_block_textures(save_path):
    base_texture = Image.open("textures/featherBlocks/FeatherBlockBaseTexture.png")
    for color in colors:
        generate_colored_texture(base_texture, color, save_path + color + "_feather_block.png")


def generate_feather_textures(save_path):
    base_texture = Image.open("textures/feathers/ItemSprite_feather.webp")
    for color in colors:
        if color != "white":
            generate_colored_texture(base_texture, color, save_path + color + "_feather.png")


def generate_feather_armors(save_path):
    for armor_type in ["helmet", "chestplate", "leggings", "boots", "winged_boots", "layer_1", "layer_2"]:
        base_texture = Image.open("textures/featherArmor/base_feather_" + armor_type + ".png")
        for color in colors:
            save_path_addition = "models/armor/" if armor_type in ["layer_1", "layer_2"] else "item/"
            full_save_path = save_path + save_path_addition + color + "_feather_" + armor_type + ".png"
            generate_colored_texture(base_texture, color, full_save_path)


def less_dark_crow(save_path):
    base_texture = Image.open("textures/birds/crow.png")
    texture_copy = base_texture.copy()
    alter_texture(texture_copy, 1, 255, whiten_crow_pixel)
    texture_copy.save(save_path)


# generate_feather_block_textures("../main/resources/assets/birds_and_feathers/textures/block/")
# generate_feather_textures("textures/test_save/")
# generate_feather_armors("../main/resources/assets/birds_and_feathers/textures/")
less_dark_crow("textures/test_save/crow_test.png")
