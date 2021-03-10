const gridTraveller = (n,m) => {
    if(m===1 && n=== 1) return 1;
    if(m===0 || n=== 0) return 0;
    return gridTraveller(n-1, m) + gridTraveller(n, m-1)
}

console.log(gridTraveller(18,18))