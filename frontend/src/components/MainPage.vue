<template>
    <div>
        <span>ID : </span>
        <input id="id" v-model="userId">
    </div>
    <div>
        <span>Password : </span>
        <input id="pw" v-model="userPw">
    </div>
    <button @click="onButtonClick">login</button>
</template>

<script>
import axios from "axios";

export default {
    name: 'MainPage',
    data: () => {
        return {
            userId: '',
            userPw: ''
        }
    },
    methods: {
        onButtonClick() {
            let userDTO = {};
            userDTO.userId = this.userId;
            userDTO.userPw = this.userPw;
            axios.post("http://localhost:8080/api" + "/login", userDTO, {
                headers: {
                    "Content-Type": `application/json`,
                }
            })
            .then((res) => {
                console.log("성공 : ", res)
            });
        }
    }
}
</script>
