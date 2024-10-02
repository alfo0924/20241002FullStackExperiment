<template>
  <div :class="{ 'dark-mode': isDark, 'light-mode': !isDark }">
    <h1>Page B</h1>
    <button @click="toggleTheme">切換淺色/深色模式</button>
    <button @click="$router.push('/')">到 A 頁</button>
    <button @click="fetchData">顯示資料庫內容</button>
    <div v-if="numbers.length">
      <h2>資料庫內容:</h2>
      <ul>
        <li v-for="number in numbers" :key="number.id">{{ number.number }}</li>
      </ul>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      isDark: true,
      numbers: []
    };
  },
  methods: {
    toggleTheme() {
      this.isDark = !this.isDark;
    },
    fetchData() {
      axios.get('/api/get-random-numbers')
          .then(response => {
            this.numbers = response.data;
          })
          .catch(error => {
            console.error('獲取資料失敗:', error);
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