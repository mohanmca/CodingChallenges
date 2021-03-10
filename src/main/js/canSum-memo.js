const canSum = (targetSum, numbers, memo={}) => {
    if(targetSum in memo) return memo[targetSum];
    if(targetSum === 0) return true;
    if(targetSum < 0) return false;

    for(let num of numbers) {
        const reminder = targetSum-num;
        if(canSum(reminder, numbers, memo) === true) {
            memo[targetSum] = true;
            return true;
        }
    }
    memo[targetSum] = false;
    return memo[targetSum];
}

console.log(canSum(7,[2,3]))
console.log(canSum(7,[1,2,4,9,13]))
console.log(canSum(17,[1,2,4,9,13]))
console.log(canSum(300,[7,14]))