#version 410

precision mediump float;

struct LightSource {
	vec2 position;
	vec3 color;
	float intensity;
};

uniform LightSource lights[100];

out vec4 FragColor;

void main() {
	vec2 p = (gl_FragCoord.xy) / min(resolution.x, resolution.y);

	for (int i = 0; i < 100; i++) {
		if (lights[i].color.r == 0.0 && lights[i].color.g == 0.0 && lights[i].color.b == 0.0)
			break;
		vec3 h = ((lights[i].intensity / 10.0) / abs(length(vec2(lights[i].position.x * (max(resolution.x, resolution.y) / min(resolution.x, resolution.y)), lights[i].position.y) - p))) * lights[i].color;
		color += h;
	}

	FragColor = color;
} 
