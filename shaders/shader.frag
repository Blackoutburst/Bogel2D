#version 460
out vec4 FragColor;

void main()
{
	vec2 p = gl_FragCoord.xy/vec2(1280, 720);
    FragColor = vec4(p.x, p.y, 1.0f, 1.0f);
} 