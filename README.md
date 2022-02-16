[![License](https://img.shields.io/github/license/Blackoutburst/Bogel2D.svg)](LICENSE)
[![Release](https://img.shields.io/github/release/Blackoutburst/Bogel2D.svg)](https://github.com/Blackoutburst/Bogel2D/releases)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/37239b44052b4e448a2e75de9b3684f4)](https://www.codacy.com/gh/Blackoutburst/Bogel2D/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Blackoutburst/Bogel2D&amp;utm_campaign=Badge_Grade)
![Size](https://github-size-badge.herokuapp.com/Blackoutburst/Bogel2D.svg)

# Bogel2D
I really simple abstraction of LWJGL 3, used to create small 2D game and other fast 2D prototype

## Get started
Link [Bogel2D](https://github.com/Blackoutburst/Bogel2D/releases) to your project and Bogel2D dependencies which can be found [here](libs/) and don't forget to link your system [natives](natives/)

Minimal code
```java
import com.blackoutburst.bogel.core.Display;
import com.blackoutburst.bogel.graphics.Color;
import com.blackoutburst.bogel.graphics.Shape;
import com.blackoutburst.bogel.graphics.Shape.ShapeType;
import com.blackoutburst.bogel.maths.Vector2f;

public class HelloWorld {
    
    public static void main(String[] args) {
        Display display = new Display().setSize(600, 600).create();

        Shape shape = new Shape(Shape.ShapeType.QUAD, new Vector2f(300), new Vector2f(400), 0, false)
                .setColor(Color.BOGEL);
        
        while (display.isOpen()) {
            display.clear();
            shape.draw();
            display.update();
        }
        display.destroy();
    }
}
```
This code should provide the following output\
![image](https://user-images.githubusercontent.com/30992311/144860034-9cdd057c-7aaf-44ef-9328-68923d384167.png)

