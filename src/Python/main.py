from PIL import Image

w_min, w_max = 190, 255

colors = ["white", "light_gray", "gray", "black", "brown", "red", "orange", "yellow", "lime", "green", "cyan",
          "light_blue", "blue", "purple", "magenta", "pink"]


def generate_feather_blocks(save_path):
    base_texture = Image.open("textures/featherBlocks/FeatherBlockBaseTexture.png")

    for color in colors:
        colored_wool_extrema = Image.open("textures/wool/BlockSprite_" + color + "-wool.webp").getextrema()
        result = base_texture.copy()
        for x in range(16):
            for y in range(16):
                pixel = list(result.getpixel((x, y)))
                for component in range(3):
                    c_min, c_max = colored_wool_extrema[component]
                    initial_value = pixel[component]
                    pixel[component] = int(c_min + (initial_value-w_min) * (c_max-c_min)/(w_max-w_min))
                result.putpixel((x, y), (pixel[0], pixel[1], pixel[2]))

        result.save(save_path + color + "_feather_block.png")


generate_feather_blocks("../main/resources/assets/birds_and_feathers/textures/block/")
