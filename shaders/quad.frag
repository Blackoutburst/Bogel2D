#version 410

precision mediump float;

in vec2 uv;

uniform vec4 color;
uniform sampler2D text;

out vec4 FragColor;

void main()
{
        FragColor = color * texture(text, uv);
} 
