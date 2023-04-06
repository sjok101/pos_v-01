const Home = () => {

    const handeClick = () => {
        console.log('greetings');
    }

    return (  
        <div className="home">
            <h2>Homepage</h2>
            <button onClick = {handeClick}>hi</button>
        </div>
    );
}
 
export default Home;