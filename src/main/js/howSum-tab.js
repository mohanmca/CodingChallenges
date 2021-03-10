const howSum = (targetSum, numbers) => {
    let N = targetSum+1;
    const table = new Array(N).fill(null);
    table[0] = [];
    for(let i=0;i<N;i++) {
        if(table[i] !== null) {
            for (let num of numbers) {
               if(i+num < N) table[i+num] = [num, ...table[i]];
            }
        }
    }
//    let result = table.filter( arr => arr !== null).filter( arr => arr.reduce((a,b) => (a+b), 0) ===  targetSum)
//    if(result.length>=1) return result[0]
    return table[targetSum]
}
console.log(howSum(7,[2,3]))
//console.log(howSum(7,[5,3,4,7]))
//console.log(howSum(8,[2,3, 5]))
//console.log(howSum(7,[2,3]))
//console.log(howSum(7,[2,4,9,13]))
//console.log(howSum(17,[2,4,9,13]))
//console.log(howSum(300,[7,14]))