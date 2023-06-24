import axios from "axios";


export default ({
    login: async ( email, password) => {
        try{
            const currentUser = await fetch(
              "https://localhost:8080/signin"
            ).then((data) => console.log(data));
        } catch (error) {
            console.error("Error:", error);
        }   
    }
})

