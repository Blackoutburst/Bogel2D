[![License](https://img.shields.io/github/license/Blackoutburst/Bogel2D.svg)](LICENSE)
[![Release](https://img.shields.io/github/release/Blackoutburst/Bogel2D.svg)](https://github.com/Blackoutburst/Bogel2D/releases)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/37239b44052b4e448a2e75de9b3684f4)](https://www.codacy.com/gh/Blackoutburst/Bogel2D/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Blackoutburst/Bogel2D&amp;utm_campaign=Badge_Grade)

# Bogel2D
I really simple abstraction of LWJGL 3, used to create small 2D game and other fast 2D prototype

## Get started
Link Bogel2D to your project and Bogel2D dependencies which can be found [here](libs/) and don't forget to link your system [natives](natives/)

Minimal code
```java
import com.blackoutburst.bogel.display.Display;
import com.blackoutburst.bogel.graphics.Color;
import com.blackoutburst.bogel.graphics.Quad;
import com.blackoutburst.bogel.maths.Vector2f;

public class Main {
    
    public static void main(String[] args) {
        Display display = new Display().setSize(600, 600).create();
        
        Quad quad = new Quad(new Vector2f(Display.getWidth()/2, Display.getHeight()/2), new Vector2f(400, 400), Color.ORANGE);
        
        while (display.isOpen()) {
            display.clear();
            quad.draw();
            display.update();
        }
    }
}
```
This code should provide the following output\
![image](https://user-images.githubusercontent.com/30992311/143481297-0791b9e1-b9f4-4132-ac2b-893b588f414c.png)

