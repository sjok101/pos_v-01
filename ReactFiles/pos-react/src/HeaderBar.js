const HeaderBar = () => {
    return (  
        <nav className="navbar">
            <div className="flex items-center px-10">
            <h1> Ticket screen header</h1>
            <button >press me!</button>
            <div className="links">
                <a href="/">Home</a>
                <a href="/takeout" style={{
                    borderRadius: '8px'
                }}>Takeout</a>

            </div>
            </div>
        </nav>
    );
}
 
export default HeaderBar;