<template>
	<div class="container">
		<div class="picture-wall-container">
			<div id="gallery">
				<article class="card" v-for="(image, index) in imagesList" :key="index">
					<div
						style="display: flex;flex-direction: column;justify-content: center;align-items: center;gap:1vh;">
						<el-image class="card-image" :src="image.src" fit="cover" />
						<label>两只猪的故事</label>
						<label>{{ image.date }}</label>
					</div>
				</article>

			</div>
		</div>

	</div>
</template>

<script setup lang="ts">
	import { ref } from 'vue';
	import $ from 'jquery'
	import cardSpreadPosition from "@/dependency/js/CardSpreadPosition.js";

	interface cardImage {
		src: string;
		date: string;
	}

	const imagesList = ref<Array<cardImage>>([
		{ src: "/images/picture_heart_images/1-1.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/1-2.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/1-3.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/1-4.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/1-5.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/1-6.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/1-7.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/1-8.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/2-1.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/2-2.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/2-3.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/2-4.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/2-5.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/2-6.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/2-7.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/2-8.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/2-9.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/2-10.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/2-11.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/2-12.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/3-1.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/3-2.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/3-3.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/3-4.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/3-5.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/3-6.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/3-7.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/3-8.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/3-9.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/3-10.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/3-11.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/3-12.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/3-13.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/3-14.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/3-15.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/3-16.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/4-1.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/4-2.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/4-3.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/4-4.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/4-5.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/4-6.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/4-7.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/4-8.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/4-9.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/4-10.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/4-11.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/4-12.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/4-13.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/4-14.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/5-1.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/5-2.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/5-3.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/5-4.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/5-5.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/5-6.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/5-7.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/5-8.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/5-9.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/5-10.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/5-11.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/5-12.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/6-1.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/6-2.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/6-3.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/6-4.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/6-5.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/6-6.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/6-7.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/6-8.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/6-9.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/6-10.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/7-1.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/7-2.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/7-3.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/7-4.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/7-5.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/7-6.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/8-1.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/8-2.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/8-3.jpg", date: "2021-01-16" },
		{ src: "/images/picture_heart_images/8-4.jpg", date: "2021-01-16" },
	])

	$(document).ready(() => {
		cardSpreadPosition.run({
			element: ".card",
			rangeAngle: 20,
			rangeX: 15,
			rangeY: 10,
			randomOrder: true
		});
	})
</script>

<style lang="scss" scoped>
	.row-container {
		display: flex;
		flex-direction: row;
		align-items: center;
	}

	.column-container {
		display: flex;
		flex-direction: column;
		align-items: center;
	}

	.container {
		@extend .row-container;

		width: 100%;
		min-height: 100vh;
		position: relative;
	}

	.picture-wall-container {
		display: grid;
		place-items: center;
		width: 100%;
		margin-top: 900vh;
		padding-bottom: 120vh;
	}

	@import url("https://fonts.googleapis.com/css2?family=Asap&display=swap");

	* {
		margin: 0;
		padding: 0;
		box-sizing: border-box;
	}

	*::before,
	*::after {
		box-sizing: border-box;
	}

	#gallery {
		--size-w: 200px;
		--size-h: calc(var(--size-w) * 1.25);

		position: relative;
		width: min(100%, 1000px);
		overflow-x: visible;
		display: flex;
		flex-wrap: wrap;
		justify-content: center;
		align-content: center;
		align-items: flex-start;

		gap: 10px;
		padding: 10px;
	}

	@media (max-width: 500px) {
		#gallery {
			--size-w: 40vw;
		}
	}

	@property --card-angle {
		syntax: "<angle>";
		initial-value: 0deg;
		inherits: false;
	}

	@property --card-x {
		syntax: "<length>";
		initial-value: 0px;
		inherits: false;
	}

	@property --card-y {
		syntax: "<length>";
		initial-value: 0px;
		inherits: false;
	}

	.card {
		--card-x: 0px;
		/* auto set by CardSpreadPosition.js */
		--card-y: 0px;
		/* auto set by CardSpreadPosition.js */
		--card-angle: 0deg;
		/* auto set by CardSpreadPosition.js */

		/* sticky! */
		--sticky-visible-h: max(2rem, 5vh);
		position: sticky;
		bottom: calc((var(--size-h) - var(--sticky-visible-h)) * -1);

		display: grid;
		place-items: center;

		width: var(--size-w);
		height: var(--size-h);
		padding: 0.5rem;

		background-color: floralwhite;
		border-radius: 10px;
		box-shadow: 0.15rem 0.15rem 0.5rem #888;

		animation: anim linear both;
		animation-timeline: view();
		animation-range: entry 100% contain 80%;
		animation-duration: 1ms;
		/* for firefox*/
		transform-origin: center;
		transform: rotate3d(0, 0, 1, var(--card-angle)) translate3d(var(--card-x), var(--card-y), 0);

		.card-image {
			height: 20vh;
		}
	}

	@keyframes anim {
		to {
			--card-x: 0px;
			--card-y: 0px;
		}
	}

	.card * {
		overflow-wrap: anywhere;
	}

	.msg {
		display: none;
		color: crimson;
	}

	/* animation-timeline 非対応ブラウザ用 */
	@supports not (animation-timeline: view()) {
		.msg {
			display: block;
		}
	}

	footer {
		position: relative;
		min-height: 100vh;
		display: grid;
		place-items: center;
		color: dimgray;
	}

	a {
		color: currentColor;
		font-weight: bold;
	}

	h2 {
		text-transform: capitalize;
		font-size: 1.7rem;
	}

	article:nth-child(5n + 1 of .card) {
		background-color: lightcyan;
	}

	article:nth-child(5n + 2 of .card) {
		background-color: peachpuff;
	}

	article:nth-child(5n + 3 of .card) {
		background-color: lavender;
	}

	article:nth-child(5n + 4 of .card) {
		background-color: ivory;
	}

	article:nth-child(5n + 5 of .card) {
		background-color: mistyrose;
	}

</style>