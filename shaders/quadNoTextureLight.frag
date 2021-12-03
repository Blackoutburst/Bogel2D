#version 410

precision mediump float;

uniform vec4 color;

out vec4 FragColor;

struct LightSource {
	vec2 position;
	vec3 color;
	float intensity;
};

uniform LightSource lights[100];

void main() {
	vec2 p = (gl_FragCoord.xy) / min(resolution.x, resolution.y);

	for (int i = 0; i < 100; i++) {
		if (lights[i].color.r == 0.0 && lights[i].color.g == 0.0 && lights[i].color.b == 0.0)
			break;
		vec3 h = (lights[i].intensity / abs(length(lights[i].position))) * lights[i].color;
		color += h;
	}

	FragColor = color;
} 
