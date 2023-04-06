const HeaderBar = () => {
    return (  
        <nav className="navbar">
            <h1> Ticket screen header</h1>
            <div className="links">
                <a href="/">Home</a>
                <a href="/takeout" style={{
                    color: "white",
                    backgroundColor: '#f1356d',
                    borderRadius: '8px'
                }}>TakeOut</a>

            </div>

        </nav>
    );
}
 
export default HeaderBar;