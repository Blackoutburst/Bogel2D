#version 460

precision mediump float;

out vec4 FragColor;

void main()
{
	vec2 p = gl_FragCoord.xy / vec2(1280.0, 720.0);
    FragColor = vec4(vec3(p.x, p.y, 1.0), 1.0);
} 