<template>
	<div class="scratch-container">
		<div id="scratch-win" class="scratch-win">
			<div class="scratch-win__title">刮刮乐</div>
			<div class="scratch-win__scratcher">
				<div class="scratch-win__background">{{ awards[awardIndex] }}</div>
				<canvas id="canvas" class="scratch-win__foreground"></canvas>
			</div>
		</div>

		<!-- <div id="coin" class="scratch-win__coin">
			<div class="scratch-win__coin-side"></div>
			<div class="scratch-win__coin-base"></div>
		</div> -->

		<div id="confetti" class="confetti">
			<svg class="confetti__item confetti__item--circle" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M0.979033 1.30301C1.85813 0.337112 3.35383 0.26675 4.31973 1.14585C5.28563 2.02495 5.35599 3.52065 4.47684 4.48647C3.59775 5.45237 2.10205 5.52273 1.13623 4.64358C0.170248 3.76453 0.0999339 2.26891 0.979033 1.30301Z"
					fill="#a864fd" />
			</svg>
			<svg class="confetti__item confetti__item--circle" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M0.979033 1.30301C1.85813 0.337112 3.35383 0.26675 4.31973 1.14585C5.28563 2.02495 5.35599 3.52065 4.47684 4.48647C3.59775 5.45237 2.10205 5.52273 1.13623 4.64358C0.170248 3.76453 0.0999339 2.26891 0.979033 1.30301Z"
					fill="#a864fd" />
			</svg>
			<svg class="confetti__item confetti__item--circle" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M0.979033 1.30301C1.85813 0.337112 3.35383 0.26675 4.31973 1.14585C5.28563 2.02495 5.35599 3.52065 4.47684 4.48647C3.59775 5.45237 2.10205 5.52273 1.13623 4.64358C0.170248 3.76453 0.0999339 2.26891 0.979033 1.30301Z"
					fill="#a864fd" />
			</svg>
			<svg class="confetti__item confetti__item--circle" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M0.979033 1.30301C1.85813 0.337112 3.35383 0.26675 4.31973 1.14585C5.28563 2.02495 5.35599 3.52065 4.47684 4.48647C3.59775 5.45237 2.10205 5.52273 1.13623 4.64358C0.170248 3.76453 0.0999339 2.26891 0.979033 1.30301Z"
					fill="#a864fd" />
			</svg>
			<svg class="confetti__item confetti__item--circle" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M0.979033 1.30301C1.85813 0.337112 3.35383 0.26675 4.31973 1.14585C5.28563 2.02495 5.35599 3.52065 4.47684 4.48647C3.59775 5.45237 2.10205 5.52273 1.13623 4.64358C0.170248 3.76453 0.0999339 2.26891 0.979033 1.30301Z"
					fill="#a864fd" />
			</svg>
			<svg class="confetti__item confetti__item--circle" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M0.979033 1.30301C1.85813 0.337112 3.35383 0.26675 4.31973 1.14585C5.28563 2.02495 5.35599 3.52065 4.47684 4.48647C3.59775 5.45237 2.10205 5.52273 1.13623 4.64358C0.170248 3.76453 0.0999339 2.26891 0.979033 1.30301Z"
					fill="#a864fd" />
			</svg>
			<svg class="confetti__item confetti__item--circle" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M0.979033 1.30301C1.85813 0.337112 3.35383 0.26675 4.31973 1.14585C5.28563 2.02495 5.35599 3.52065 4.47684 4.48647C3.59775 5.45237 2.10205 5.52273 1.13623 4.64358C0.170248 3.76453 0.0999339 2.26891 0.979033 1.30301Z"
					fill="#a864fd" />
			</svg>
			<svg class="confetti__item confetti__item--circle" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M0.979033 1.30301C1.85813 0.337112 3.35383 0.26675 4.31973 1.14585C5.28563 2.02495 5.35599 3.52065 4.47684 4.48647C3.59775 5.45237 2.10205 5.52273 1.13623 4.64358C0.170248 3.76453 0.0999339 2.26891 0.979033 1.30301Z"
					fill="#a864fd" />
			</svg>
			<svg class="confetti__item confetti__item--circle" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M0.979033 1.30301C1.85813 0.337112 3.35383 0.26675 4.31973 1.14585C5.28563 2.02495 5.35599 3.52065 4.47684 4.48647C3.59775 5.45237 2.10205 5.52273 1.13623 4.64358C0.170248 3.76453 0.0999339 2.26891 0.979033 1.30301Z"
					fill="#29cdff" />
			</svg>
			<svg class="confetti__item confetti__item--circle" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M0.979033 1.30301C1.85813 0.337112 3.35383 0.26675 4.31973 1.14585C5.28563 2.02495 5.35599 3.52065 4.47684 4.48647C3.59775 5.45237 2.10205 5.52273 1.13623 4.64358C0.170248 3.76453 0.0999339 2.26891 0.979033 1.30301Z"
					fill="#29cdff" />
			</svg>
			<svg class="confetti__item confetti__item--circle" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M0.979033 1.30301C1.85813 0.337112 3.35383 0.26675 4.31973 1.14585C5.28563 2.02495 5.35599 3.52065 4.47684 4.48647C3.59775 5.45237 2.10205 5.52273 1.13623 4.64358C0.170248 3.76453 0.0999339 2.26891 0.979033 1.30301Z"
					fill="#29cdff" />
			</svg>
			<svg class="confetti__item confetti__item--circle" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M0.979033 1.30301C1.85813 0.337112 3.35383 0.26675 4.31973 1.14585C5.28563 2.02495 5.35599 3.52065 4.47684 4.48647C3.59775 5.45237 2.10205 5.52273 1.13623 4.64358C0.170248 3.76453 0.0999339 2.26891 0.979033 1.30301Z"
					fill="#29cdff" />
			</svg>
			<svg class="confetti__item confetti__item--circle" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M0.979033 1.30301C1.85813 0.337112 3.35383 0.26675 4.31973 1.14585C5.28563 2.02495 5.35599 3.52065 4.47684 4.48647C3.59775 5.45237 2.10205 5.52273 1.13623 4.64358C0.170248 3.76453 0.0999339 2.26891 0.979033 1.30301Z"
					fill="#29cdff" />
			</svg>
			<svg class="confetti__item confetti__item--circle" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M0.979033 1.30301C1.85813 0.337112 3.35383 0.26675 4.31973 1.14585C5.28563 2.02495 5.35599 3.52065 4.47684 4.48647C3.59775 5.45237 2.10205 5.52273 1.13623 4.64358C0.170248 3.76453 0.0999339 2.26891 0.979033 1.30301Z"
					fill="#29cdff" />
			</svg>
			<svg class="confetti__item confetti__item--square" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M5.30075 0.975439L5.14456 4.94522C5.13632 5.15408 4.96042 5.3166 4.75161 5.30844L0.781828 5.15225C0.572971 5.14401 0.410451 4.96811 0.41861 4.7593L0.5748 0.789518C0.583039 0.580661 0.758938 0.418139 0.967749 0.426298L4.93753 0.582489C5.14639 0.590727 5.30896 0.766708 5.30075 0.975439Z"
					fill="#78ff44" />
			</svg>
			<svg class="confetti__item confetti__item--square" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M5.30075 0.975439L5.14456 4.94522C5.13632 5.15408 4.96042 5.3166 4.75161 5.30844L0.781828 5.15225C0.572971 5.14401 0.410451 4.96811 0.41861 4.7593L0.5748 0.789518C0.583039 0.580661 0.758938 0.418139 0.967749 0.426298L4.93753 0.582489C5.14639 0.590727 5.30896 0.766708 5.30075 0.975439Z"
					fill="#78ff44" />
			</svg>
			<svg class="confetti__item confetti__item--square" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M5.30075 0.975439L5.14456 4.94522C5.13632 5.15408 4.96042 5.3166 4.75161 5.30844L0.781828 5.15225C0.572971 5.14401 0.410451 4.96811 0.41861 4.7593L0.5748 0.789518C0.583039 0.580661 0.758938 0.418139 0.967749 0.426298L4.93753 0.582489C5.14639 0.590727 5.30896 0.766708 5.30075 0.975439Z"
					fill="#78ff44" />
			</svg>
			<svg class="confetti__item confetti__item--square" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M5.30075 0.975439L5.14456 4.94522C5.13632 5.15408 4.96042 5.3166 4.75161 5.30844L0.781828 5.15225C0.572971 5.14401 0.410451 4.96811 0.41861 4.7593L0.5748 0.789518C0.583039 0.580661 0.758938 0.418139 0.967749 0.426298L4.93753 0.582489C5.14639 0.590727 5.30896 0.766708 5.30075 0.975439Z"
					fill="#78ff44" />
			</svg>
			<svg class="confetti__item confetti__item--square" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M5.30075 0.975439L5.14456 4.94522C5.13632 5.15408 4.96042 5.3166 4.75161 5.30844L0.781828 5.15225C0.572971 5.14401 0.410451 4.96811 0.41861 4.7593L0.5748 0.789518C0.583039 0.580661 0.758938 0.418139 0.967749 0.426298L4.93753 0.582489C5.14639 0.590727 5.30896 0.766708 5.30075 0.975439Z"
					fill="#78ff44" />
			</svg>
			<svg class="confetti__item confetti__item--square" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M5.30075 0.975439L5.14456 4.94522C5.13632 5.15408 4.96042 5.3166 4.75161 5.30844L0.781828 5.15225C0.572971 5.14401 0.410451 4.96811 0.41861 4.7593L0.5748 0.789518C0.583039 0.580661 0.758938 0.418139 0.967749 0.426298L4.93753 0.582489C5.14639 0.590727 5.30896 0.766708 5.30075 0.975439Z"
					fill="#78ff44" />
			</svg>
			<svg class="confetti__item confetti__item--square" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M5.30075 0.975439L5.14456 4.94522C5.13632 5.15408 4.96042 5.3166 4.75161 5.30844L0.781828 5.15225C0.572971 5.14401 0.410451 4.96811 0.41861 4.7593L0.5748 0.789518C0.583039 0.580661 0.758938 0.418139 0.967749 0.426298L4.93753 0.582489C5.14639 0.590727 5.30896 0.766708 5.30075 0.975439Z"
					fill="#78ff44" />
			</svg>
			<svg class="confetti__item confetti__item--square" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M5.30075 0.975439L5.14456 4.94522C5.13632 5.15408 4.96042 5.3166 4.75161 5.30844L0.781828 5.15225C0.572971 5.14401 0.410451 4.96811 0.41861 4.7593L0.5748 0.789518C0.583039 0.580661 0.758938 0.418139 0.967749 0.426298L4.93753 0.582489C5.14639 0.590727 5.30896 0.766708 5.30075 0.975439Z"
					fill="#ff718d" />
			</svg>
			<svg class="confetti__item confetti__item--square" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M5.30075 0.975439L5.14456 4.94522C5.13632 5.15408 4.96042 5.3166 4.75161 5.30844L0.781828 5.15225C0.572971 5.14401 0.410451 4.96811 0.41861 4.7593L0.5748 0.789518C0.583039 0.580661 0.758938 0.418139 0.967749 0.426298L4.93753 0.582489C5.14639 0.590727 5.30896 0.766708 5.30075 0.975439Z"
					fill="#ff718d" />
			</svg>
			<svg class="confetti__item confetti__item--square" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M5.30075 0.975439L5.14456 4.94522C5.13632 5.15408 4.96042 5.3166 4.75161 5.30844L0.781828 5.15225C0.572971 5.14401 0.410451 4.96811 0.41861 4.7593L0.5748 0.789518C0.583039 0.580661 0.758938 0.418139 0.967749 0.426298L4.93753 0.582489C5.14639 0.590727 5.30896 0.766708 5.30075 0.975439Z"
					fill="#ff718d" />
			</svg>
			<svg class="confetti__item confetti__item--square" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M5.30075 0.975439L5.14456 4.94522C5.13632 5.15408 4.96042 5.3166 4.75161 5.30844L0.781828 5.15225C0.572971 5.14401 0.410451 4.96811 0.41861 4.7593L0.5748 0.789518C0.583039 0.580661 0.758938 0.418139 0.967749 0.426298L4.93753 0.582489C5.14639 0.590727 5.30896 0.766708 5.30075 0.975439Z"
					fill="#ff718d" />
			</svg>
			<svg class="confetti__item confetti__item--square" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M5.30075 0.975439L5.14456 4.94522C5.13632 5.15408 4.96042 5.3166 4.75161 5.30844L0.781828 5.15225C0.572971 5.14401 0.410451 4.96811 0.41861 4.7593L0.5748 0.789518C0.583039 0.580661 0.758938 0.418139 0.967749 0.426298L4.93753 0.582489C5.14639 0.590727 5.30896 0.766708 5.30075 0.975439Z"
					fill="#ff718d" />
			</svg>
			<svg class="confetti__item confetti__item--square" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M5.30075 0.975439L5.14456 4.94522C5.13632 5.15408 4.96042 5.3166 4.75161 5.30844L0.781828 5.15225C0.572971 5.14401 0.410451 4.96811 0.41861 4.7593L0.5748 0.789518C0.583039 0.580661 0.758938 0.418139 0.967749 0.426298L4.93753 0.582489C5.14639 0.590727 5.30896 0.766708 5.30075 0.975439Z"
					fill="#ff718d" />
			</svg>
			<svg class="confetti__item confetti__item--square" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M5.30075 0.975439L5.14456 4.94522C5.13632 5.15408 4.96042 5.3166 4.75161 5.30844L0.781828 5.15225C0.572971 5.14401 0.410451 4.96811 0.41861 4.7593L0.5748 0.789518C0.583039 0.580661 0.758938 0.418139 0.967749 0.426298L4.93753 0.582489C5.14639 0.590727 5.30896 0.766708 5.30075 0.975439Z"
					fill="#ff718d" />
			</svg>
			<svg class="confetti__item confetti__item--square" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M5.30075 0.975439L5.14456 4.94522C5.13632 5.15408 4.96042 5.3166 4.75161 5.30844L0.781828 5.15225C0.572971 5.14401 0.410451 4.96811 0.41861 4.7593L0.5748 0.789518C0.583039 0.580661 0.758938 0.418139 0.967749 0.426298L4.93753 0.582489C5.14639 0.590727 5.30896 0.766708 5.30075 0.975439Z"
					fill="#ff718d" />
			</svg>
			<svg class="confetti__item confetti__item--circle" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M0.979033 1.30301C1.85813 0.337112 3.35383 0.26675 4.31973 1.14585C5.28563 2.02495 5.35599 3.52065 4.47684 4.48647C3.59775 5.45237 2.10205 5.52273 1.13623 4.64358C0.170248 3.76453 0.0999339 2.26891 0.979033 1.30301Z"
					fill="#a864fd" />
			</svg>
			<svg class="confetti__item confetti__item--circle" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M0.979033 1.30301C1.85813 0.337112 3.35383 0.26675 4.31973 1.14585C5.28563 2.02495 5.35599 3.52065 4.47684 4.48647C3.59775 5.45237 2.10205 5.52273 1.13623 4.64358C0.170248 3.76453 0.0999339 2.26891 0.979033 1.30301Z"
					fill="#a864fd" />
			</svg>
			<svg class="confetti__item confetti__item--circle" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M0.979033 1.30301C1.85813 0.337112 3.35383 0.26675 4.31973 1.14585C5.28563 2.02495 5.35599 3.52065 4.47684 4.48647C3.59775 5.45237 2.10205 5.52273 1.13623 4.64358C0.170248 3.76453 0.0999339 2.26891 0.979033 1.30301Z"
					fill="#a864fd" />
			</svg>
			<svg class="confetti__item confetti__item--circle" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M0.979033 1.30301C1.85813 0.337112 3.35383 0.26675 4.31973 1.14585C5.28563 2.02495 5.35599 3.52065 4.47684 4.48647C3.59775 5.45237 2.10205 5.52273 1.13623 4.64358C0.170248 3.76453 0.0999339 2.26891 0.979033 1.30301Z"
					fill="#a864fd" />
			</svg>
			<svg class="confetti__item confetti__item--circle" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M0.979033 1.30301C1.85813 0.337112 3.35383 0.26675 4.31973 1.14585C5.28563 2.02495 5.35599 3.52065 4.47684 4.48647C3.59775 5.45237 2.10205 5.52273 1.13623 4.64358C0.170248 3.76453 0.0999339 2.26891 0.979033 1.30301Z"
					fill="#a864fd" />
			</svg>
			<svg class="confetti__item confetti__item--circle" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M0.979033 1.30301C1.85813 0.337112 3.35383 0.26675 4.31973 1.14585C5.28563 2.02495 5.35599 3.52065 4.47684 4.48647C3.59775 5.45237 2.10205 5.52273 1.13623 4.64358C0.170248 3.76453 0.0999339 2.26891 0.979033 1.30301Z"
					fill="#a864fd" />
			</svg>
			<svg class="confetti__item confetti__item--circle" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M0.979033 1.30301C1.85813 0.337112 3.35383 0.26675 4.31973 1.14585C5.28563 2.02495 5.35599 3.52065 4.47684 4.48647C3.59775 5.45237 2.10205 5.52273 1.13623 4.64358C0.170248 3.76453 0.0999339 2.26891 0.979033 1.30301Z"
					fill="#a864fd" />
			</svg>
			<svg class="confetti__item confetti__item--circle" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M0.979033 1.30301C1.85813 0.337112 3.35383 0.26675 4.31973 1.14585C5.28563 2.02495 5.35599 3.52065 4.47684 4.48647C3.59775 5.45237 2.10205 5.52273 1.13623 4.64358C0.170248 3.76453 0.0999339 2.26891 0.979033 1.30301Z"
					fill="#a864fd" />
			</svg>
			<svg class="confetti__item confetti__item--circle" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M0.979033 1.30301C1.85813 0.337112 3.35383 0.26675 4.31973 1.14585C5.28563 2.02495 5.35599 3.52065 4.47684 4.48647C3.59775 5.45237 2.10205 5.52273 1.13623 4.64358C0.170248 3.76453 0.0999339 2.26891 0.979033 1.30301Z"
					fill="#29cdff" />
			</svg>
			<svg class="confetti__item confetti__item--circle" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M0.979033 1.30301C1.85813 0.337112 3.35383 0.26675 4.31973 1.14585C5.28563 2.02495 5.35599 3.52065 4.47684 4.48647C3.59775 5.45237 2.10205 5.52273 1.13623 4.64358C0.170248 3.76453 0.0999339 2.26891 0.979033 1.30301Z"
					fill="#29cdff" />
			</svg>
			<svg class="confetti__item confetti__item--circle" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M0.979033 1.30301C1.85813 0.337112 3.35383 0.26675 4.31973 1.14585C5.28563 2.02495 5.35599 3.52065 4.47684 4.48647C3.59775 5.45237 2.10205 5.52273 1.13623 4.64358C0.170248 3.76453 0.0999339 2.26891 0.979033 1.30301Z"
					fill="#29cdff" />
			</svg>
			<svg class="confetti__item confetti__item--circle" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M0.979033 1.30301C1.85813 0.337112 3.35383 0.26675 4.31973 1.14585C5.28563 2.02495 5.35599 3.52065 4.47684 4.48647C3.59775 5.45237 2.10205 5.52273 1.13623 4.64358C0.170248 3.76453 0.0999339 2.26891 0.979033 1.30301Z"
					fill="#29cdff" />
			</svg>
			<svg class="confetti__item confetti__item--circle" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M0.979033 1.30301C1.85813 0.337112 3.35383 0.26675 4.31973 1.14585C5.28563 2.02495 5.35599 3.52065 4.47684 4.48647C3.59775 5.45237 2.10205 5.52273 1.13623 4.64358C0.170248 3.76453 0.0999339 2.26891 0.979033 1.30301Z"
					fill="#29cdff" />
			</svg>
			<svg class="confetti__item confetti__item--circle" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M0.979033 1.30301C1.85813 0.337112 3.35383 0.26675 4.31973 1.14585C5.28563 2.02495 5.35599 3.52065 4.47684 4.48647C3.59775 5.45237 2.10205 5.52273 1.13623 4.64358C0.170248 3.76453 0.0999339 2.26891 0.979033 1.30301Z"
					fill="#29cdff" />
			</svg>
			<svg class="confetti__item confetti__item--square" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M5.30075 0.975439L5.14456 4.94522C5.13632 5.15408 4.96042 5.3166 4.75161 5.30844L0.781828 5.15225C0.572971 5.14401 0.410451 4.96811 0.41861 4.7593L0.5748 0.789518C0.583039 0.580661 0.758938 0.418139 0.967749 0.426298L4.93753 0.582489C5.14639 0.590727 5.30896 0.766708 5.30075 0.975439Z"
					fill="#78ff44" />
			</svg>
			<svg class="confetti__item confetti__item--square" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M5.30075 0.975439L5.14456 4.94522C5.13632 5.15408 4.96042 5.3166 4.75161 5.30844L0.781828 5.15225C0.572971 5.14401 0.410451 4.96811 0.41861 4.7593L0.5748 0.789518C0.583039 0.580661 0.758938 0.418139 0.967749 0.426298L4.93753 0.582489C5.14639 0.590727 5.30896 0.766708 5.30075 0.975439Z"
					fill="#78ff44" />
			</svg>
			<svg class="confetti__item confetti__item--square" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M5.30075 0.975439L5.14456 4.94522C5.13632 5.15408 4.96042 5.3166 4.75161 5.30844L0.781828 5.15225C0.572971 5.14401 0.410451 4.96811 0.41861 4.7593L0.5748 0.789518C0.583039 0.580661 0.758938 0.418139 0.967749 0.426298L4.93753 0.582489C5.14639 0.590727 5.30896 0.766708 5.30075 0.975439Z"
					fill="#78ff44" />
			</svg>
			<svg class="confetti__item confetti__item--square" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M5.30075 0.975439L5.14456 4.94522C5.13632 5.15408 4.96042 5.3166 4.75161 5.30844L0.781828 5.15225C0.572971 5.14401 0.410451 4.96811 0.41861 4.7593L0.5748 0.789518C0.583039 0.580661 0.758938 0.418139 0.967749 0.426298L4.93753 0.582489C5.14639 0.590727 5.30896 0.766708 5.30075 0.975439Z"
					fill="#78ff44" />
			</svg>
			<svg class="confetti__item confetti__item--square" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M5.30075 0.975439L5.14456 4.94522C5.13632 5.15408 4.96042 5.3166 4.75161 5.30844L0.781828 5.15225C0.572971 5.14401 0.410451 4.96811 0.41861 4.7593L0.5748 0.789518C0.583039 0.580661 0.758938 0.418139 0.967749 0.426298L4.93753 0.582489C5.14639 0.590727 5.30896 0.766708 5.30075 0.975439Z"
					fill="#78ff44" />
			</svg>
			<svg class="confetti__item confetti__item--square" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M5.30075 0.975439L5.14456 4.94522C5.13632 5.15408 4.96042 5.3166 4.75161 5.30844L0.781828 5.15225C0.572971 5.14401 0.410451 4.96811 0.41861 4.7593L0.5748 0.789518C0.583039 0.580661 0.758938 0.418139 0.967749 0.426298L4.93753 0.582489C5.14639 0.590727 5.30896 0.766708 5.30075 0.975439Z"
					fill="#78ff44" />
			</svg>
			<svg class="confetti__item confetti__item--square" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M5.30075 0.975439L5.14456 4.94522C5.13632 5.15408 4.96042 5.3166 4.75161 5.30844L0.781828 5.15225C0.572971 5.14401 0.410451 4.96811 0.41861 4.7593L0.5748 0.789518C0.583039 0.580661 0.758938 0.418139 0.967749 0.426298L4.93753 0.582489C5.14639 0.590727 5.30896 0.766708 5.30075 0.975439Z"
					fill="#78ff44" />
			</svg>
			<svg class="confetti__item confetti__item--square" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M5.30075 0.975439L5.14456 4.94522C5.13632 5.15408 4.96042 5.3166 4.75161 5.30844L0.781828 5.15225C0.572971 5.14401 0.410451 4.96811 0.41861 4.7593L0.5748 0.789518C0.583039 0.580661 0.758938 0.418139 0.967749 0.426298L4.93753 0.582489C5.14639 0.590727 5.30896 0.766708 5.30075 0.975439Z"
					fill="#ff718d" />
			</svg>
			<svg class="confetti__item confetti__item--square" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M5.30075 0.975439L5.14456 4.94522C5.13632 5.15408 4.96042 5.3166 4.75161 5.30844L0.781828 5.15225C0.572971 5.14401 0.410451 4.96811 0.41861 4.7593L0.5748 0.789518C0.583039 0.580661 0.758938 0.418139 0.967749 0.426298L4.93753 0.582489C5.14639 0.590727 5.30896 0.766708 5.30075 0.975439Z"
					fill="#ff718d" />
			</svg>
			<svg class="confetti__item confetti__item--square" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M5.30075 0.975439L5.14456 4.94522C5.13632 5.15408 4.96042 5.3166 4.75161 5.30844L0.781828 5.15225C0.572971 5.14401 0.410451 4.96811 0.41861 4.7593L0.5748 0.789518C0.583039 0.580661 0.758938 0.418139 0.967749 0.426298L4.93753 0.582489C5.14639 0.590727 5.30896 0.766708 5.30075 0.975439Z"
					fill="#ff718d" />
			</svg>
			<svg class="confetti__item confetti__item--square" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M5.30075 0.975439L5.14456 4.94522C5.13632 5.15408 4.96042 5.3166 4.75161 5.30844L0.781828 5.15225C0.572971 5.14401 0.410451 4.96811 0.41861 4.7593L0.5748 0.789518C0.583039 0.580661 0.758938 0.418139 0.967749 0.426298L4.93753 0.582489C5.14639 0.590727 5.30896 0.766708 5.30075 0.975439Z"
					fill="#ff718d" />
			</svg>
			<svg class="confetti__item confetti__item--square" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M5.30075 0.975439L5.14456 4.94522C5.13632 5.15408 4.96042 5.3166 4.75161 5.30844L0.781828 5.15225C0.572971 5.14401 0.410451 4.96811 0.41861 4.7593L0.5748 0.789518C0.583039 0.580661 0.758938 0.418139 0.967749 0.426298L4.93753 0.582489C5.14639 0.590727 5.30896 0.766708 5.30075 0.975439Z"
					fill="#ff718d" />
			</svg>
			<svg class="confetti__item confetti__item--square" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M5.30075 0.975439L5.14456 4.94522C5.13632 5.15408 4.96042 5.3166 4.75161 5.30844L0.781828 5.15225C0.572971 5.14401 0.410451 4.96811 0.41861 4.7593L0.5748 0.789518C0.583039 0.580661 0.758938 0.418139 0.967749 0.426298L4.93753 0.582489C5.14639 0.590727 5.30896 0.766708 5.30075 0.975439Z"
					fill="#ff718d" />
			</svg>
			<svg class="confetti__item confetti__item--square" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M5.30075 0.975439L5.14456 4.94522C5.13632 5.15408 4.96042 5.3166 4.75161 5.30844L0.781828 5.15225C0.572971 5.14401 0.410451 4.96811 0.41861 4.7593L0.5748 0.789518C0.583039 0.580661 0.758938 0.418139 0.967749 0.426298L4.93753 0.582489C5.14639 0.590727 5.30896 0.766708 5.30075 0.975439Z"
					fill="#ff718d" />
			</svg>
			<svg class="confetti__item confetti__item--square" width="6" height="6" viewBox="0 0 6 6" fill="none"
				xmlns="http://www.w3.org/2000/svg">
				<path
					d="M5.30075 0.975439L5.14456 4.94522C5.13632 5.15408 4.96042 5.3166 4.75161 5.30844L0.781828 5.15225C0.572971 5.14401 0.410451 4.96811 0.41861 4.7593L0.5748 0.789518C0.583039 0.580661 0.758938 0.418139 0.967749 0.426298L4.93753 0.582489C5.14639 0.590727 5.30896 0.766708 5.30075 0.975439Z"
					fill="#ff718d" />
			</svg>
		</div>
	</div>
</template>

<script lang="ts" setup>
	import { ref, onMounted } from 'vue';
	import $ from 'jquery';

	const awardIndex = ref(0);
	const awards = ref<Array<string>>(["说老公我爱你", "亲老公一口", "抱老公一下", "老婆必发财"]);

	onMounted(() => {
		awardIndex.value = Math.floor(Math.random() * ((awards.value.length - 1) + 1));
	})

	$(document).ready(function () {
		const scratchWin = $("#scratch-win");
		// const coin = $("#coin");
		// const canvas = $("#canvas");
		const canvas = document.getElementById("canvas") as HTMLCanvasElement;
		const ctx = canvas.getContext("2d");

		const width: number = 320;
		const height: number = 160;

		// Paint golden gradient
		canvas.width = width;
		canvas.height = height;

		const gradient = ctx ? ctx.createLinearGradient(0, 0, width, height) : null;

		if (gradient != null) {
			gradient.addColorStop(0, "#d4af37");
			gradient.addColorStop(0.3, "#a67c00");
			gradient.addColorStop(0.5, "#d4af37");
			gradient.addColorStop(0.8, "#a67c00");
			gradient.addColorStop(1, "#d4af37");

			if (ctx != null) {
				ctx.fillStyle = gradient;
				ctx.fillRect(0, 0, width, height);
			}
		}

		scratchWin.addClass("scratch-win--ready");

		// Calculate transparency
		const confetti = $("#confetti");
		const maxPixels = width * height;

		const calculateTransparency = () => {
			const imageData = ctx ? ctx.getImageData(0, 0, width, height).data : null;

			if (imageData != null) {
				const alphaValues = imageData.filter(
					(value: any, index: any) => index % 4 === 4 - 1 && value === 0
				);
				return alphaValues.length / maxPixels;
			}
			else {
				return 0;
			}
		};

		const mouseFunction = (mouse: any) => {
			// Move coin
			const clientX = mouse.clientX ? mouse.clientX : mouse.touches[0].clientX;
			const clientY = mouse.clientY ? mouse.clientY : mouse.touches[0].clientY;
			// coin.css({
			// 	"--top": `${clientY}px`, "--left": `${clientX}px`
			// });
			// Scratch
			const canvasPosition = canvas.getBoundingClientRect();
			const canvasX = clientX - canvasPosition.left;
			const canvasY = clientY - canvasPosition.top;

			if (canvasX > 0 && canvasX < width && canvasY > 0 && canvasY < height) {
				if (ctx != null) {
					ctx.clearRect(canvasX - 10, canvasY - 10, 20, 20);
				}

				if (calculateTransparency() > 0.6) {
					confetti.addClass("confetti--active");
				}
			}
		};

		// In a real life example you should throttle these
		window.addEventListener("mousemove", mouseFunction);
		window.addEventListener("touchmove", mouseFunction);
	})
</script>

<style lang="scss" scoped>
	@import url("https://fonts.googleapis.com/css2?family=Archivo+Black&display=swap");

	$yellow: #ffbf00;
	$yellow--light: #ffdc73;
	$gold: #d4af37;
	$gold--dark: #a67c00;
	$black: #000038;
	$grey: #888;
	$white: #fff;
	$light-blue: #78d6c6;
	$dark-blue: #12486b;
	$green: #80c0a1;

	.scratch-container {
		display: flex;
		justify-content: center;
		align-items: center;
		height: 100vh;
		margin: 0;
		font-family: "Arial Black", "Archivo Black", sans-serif;
		overflow: hidden;
		cursor: none;
	}

	.scratch-win {
		position: relative;
		padding: 1rem 2rem 2rem 2rem;
		background: linear-gradient($light-blue -150%, $dark-blue);
		border: 0.2rem solid $yellow--light;
		border-radius: 1rem;
		overflow: hidden;
		box-shadow: 0.2rem 0.2rem 1rem 0 rgba($black, 0.3);

		@media screen and (max-width: 500px) {
			padding-left: 0;
			padding-right: 0;

			&__coin {
				transform: scale(0.8);
			}
		}

		&:after {
			content: "";
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height: 100%;
			background: linear-gradient(-70deg,
					transparent,
					transparent 50%,
					rgba($white, 0.1) 57%,
					transparent 60%);
			background-size: 300% 100%;
			animation: shinning;
			animation-duration: 6s;
			animation-iteration-count: infinite;
			pointer-events: none;

			@keyframes shinning {
				from {
					background-position: 0 0;
				}

				to {
					background-position: 100% 0;
				}
			}
		}

		&__title {
			width: 100%;
			margin: 0 auto 1rem;
			color: $yellow--light;
			font-size: 2rem;
			text-align: center;
			text-transform: uppercase;
			background: -webkit-linear-gradient($yellow--light, $gold--dark);
			-webkit-background-clip: text;
			-webkit-text-fill-color: transparent;
		}

		&__scratcher {
			position: relative;
			width: 20rem;
			height: 10rem;
		}

		&__background,
		&__foreground {
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height: 100%;
		}

		&__background {
			display: none;
			justify-content: center;
			align-items: center;
			color: $grey;
			background-color: $white;
			text-transform: uppercase;
			font-size: 3.6rem;

			&:after {
				content: "";
				position: absolute;
				top: 0;
				left: 0;
				width: 100%;
				height: 100%;
				background: repeating-linear-gradient(transparent,
						transparent 0.5rem,
						$grey 0.5rem,
						$grey 0.6rem);
				opacity: 0.5;
			}
		}

		&--ready .scratch-win__background {
			font-size: 3rem;
			display: flex;
		}

		&__coin {
			position: absolute;
			z-index: 2;
			top: calc(var(--top) - 5rem);
			left: calc(var(--left) - 3rem);
			width: 6rem;
			height: 6rem;
			pointer-events: none;
		}

		&__coin-side {
			position: absolute;
			top: -0.4rem;
			left: 0;
			z-index: -1;
			width: calc(100% + 0.6rem);
			height: calc(100% + 0.6rem);
			border-radius: 50%;
			outline: 0.1rem solid $gold--dark;
			background: repeating-linear-gradient(90deg,
					$gold 0,
					$gold 0.5rem,
					$yellow--light 0.5rem,
					$yellow--light 0.7rem);
			box-shadow: 0 1rem 1rem -0.5rem rgba($black, 0.5);

			@supports (-webkit-hyphens: none) {
				// removing outline in Safari
				outline: none;
			}
		}

		&__coin-base {
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height: 100%;
			border: 0.3rem dashed $gold;
			outline: 0.1rem solid $gold--dark;
			border-radius: 50%;
			background: radial-gradient(circle at 0 0, $yellow--light, $gold 150%);
			box-shadow: inset 0 -0.1rem 0 0 $gold--dark;

			@supports (-webkit-hyphens: none) {
				// removing outline in Safari
				outline: none;
			}

			&:before,
			&:after {
				content: "€";
				position: absolute;
				display: flex;
				justify-content: center;
				align-items: center;
				width: 100%;
				height: 100%;
				font-size: 4rem;
			}

			&:before {
				color: $gold--dark;
				transform: rotate(45deg) translateX(-0.4rem) translateY(-0.25rem);
			}

			&:after {
				color: $gold;
				transform: rotate(45deg) translateX(-0.3rem) translateY(-0.2rem);
				background: -webkit-linear-gradient($yellow--light -50%, $gold);
				-webkit-background-clip: text;
				-webkit-text-fill-color: transparent;
			}
		}
	}

	.confetti {
		position: absolute;
		top: 0;
		left: 0;
		z-index: 3;
		width: 100%;
		height: 200%;
		pointer-events: none;
		--top-position: -350vh;

		&__item {
			position: absolute;
			box-shadow: 1rem 1rem 1rem 0 rgba($black, 0.5);
			// Positioning confetti
			$confetti-number: 120;

			@for $i from 1 through $confetti-number {
				&:nth-child(#{$i}) {
					top: calc(#{random()} * 150% + var(--top-position));
					left: calc(#{random()} * 100%);
					transform: scale(max(#{random() * 5}, 2)) rotate(#{random() * 90}deg);
				}
			}
		}

		&--active {
			--top-position: 200vh;

			.confetti__item {
				transition: top 10s ease;

				&:nth-child(3n) {
					transition: top 8s ease;
				}

				&:nth-child(4n) {
					transition: top 12s ease;
				}
			}
		}
	}
</style>
