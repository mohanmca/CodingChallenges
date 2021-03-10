const gridTraveller = (n,m, memo={}) => {
    const key = m + ',' + n;
    if(key in memo) return memo[key];

    if(m===1 && n=== 1) return 1;
    if(m===0 || n=== 0) return 0;
    memo[key] = gridTraveller(n-1, m, memo) + gridTraveller(n, m-1, memo);
    return memo[key];
}

console.log(gridTraveller(18,18)) //2333606220