const canSum = (targetSum, numbers) => {
    let N = targetSum + 1;
    const table = new Array(N).fill(false);
    table[0] = true;

    for(let i=0; i < N;i++) {
        if(table[i] === true) {
            for (let num of numbers) {
               if(i+num < N) table[i+num] = true;
            }
        }
    }
    return table[targetSum];
}

console.log(canSum(7,[2,3]))
console.log(canSum(7,[1,2,4,9,13]))
console.log(canSum(17,[1,2,4,9,13]))
console.log(canSum(300,[7,14]))