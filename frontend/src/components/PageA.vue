<template>
  <div :class="{ 'dark-mode': isDark, 'light-mode': !isDark }">
    <h1>Page A</h1>
    <p>隨機數值: {{ randomNumber }}</p>
    <button @click="toggleTheme">切換淺色/深色模式</button>
    <button @click="$router.push('/b')">到 B 頁</button>
    <button @click="submitData">儲存並送出</button>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      isDark: true,
      randomNumber: 0
    };
  },
  created() {
    this.generateRandomNumber();
  },
  methods: {
    toggleTheme() {
      this.isDark = !this.isDark;
    },
    generateRandomNumber() {
      this.randomNumber = Math.floor(Math.random() * 1000000) + 1;
    },
    submitData() {
      axios.post('/api/save-random-number', {number: this.randomNumber})
          .then(response => {
            console.log('數據已保存', response);
            this.generateRandomNumber(); // 生成新的隨機數
          })
          .catch(error => {
            console.error('保存失敗:', error);
          });
    }
  }
}
</script>

<style scoped>
.dark-mode {
  background-color: black;
  color: white;
}

.light-mode {
  background-color: white;
  color: black;
}

div {
  padding: 20px;
}

button {
  margin: 10px;
  padding: 10px;
}
</style>